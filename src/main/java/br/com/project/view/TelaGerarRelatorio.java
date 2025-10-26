package br.com.project.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Locale;

public class TelaGerarRelatorio extends javax.swing.JInternalFrame {

    private DatePicker dataInicio;
    private DatePicker dataFim;
    private JButton btnGerarRelatorio;

    public TelaGerarRelatorio() {
        // Aplica visual moderno
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Define idioma PT-BR
        Locale.setDefault(new Locale("pt", "BR"));

        initComponents();
        adicionarComponentes();
    }

    private void initComponents() {
        setBorder(BorderFactory.createTitledBorder(null, "Relatório de Serviço",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 12)));

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new Dimension(900, 600));
        getContentPane().setLayout(null);
    }

    private void adicionarComponentes() {
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 900, 600);

        JLabel lblDe = new JLabel("De:");
        lblDe.setBounds(20, 30, 50, 25);
        painel.add(lblDe);

        dataInicio = new DatePicker();
        dataInicio.setBounds(60, 30, 180, 35);
        painel.add(dataInicio);

        JLabel lblAte = new JLabel("Até:");
        lblAte.setBounds(260, 30, 50, 25);
        painel.add(lblAte);

        dataFim = new DatePicker();
        dataFim.setBounds(300, 30, 180, 35);
        painel.add(dataFim);

        btnGerarRelatorio = new JButton("Gerar Relatório");
        btnGerarRelatorio.setBounds(500, 30, 150, 35);
        painel.add(btnGerarRelatorio);

        // Teste de funcionalidade
        btnGerarRelatorio.addActionListener(e -> {
            LocalDate inicio = dataInicio.getDate();
            LocalDate fim = dataFim.getDate();

            if (inicio == null || fim == null) {
                JOptionPane.showMessageDialog(this, "Selecione as duas datas para gerar o relatório!");
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Relatório de: " + inicio + " até " + fim,
                    "Período selecionado",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        getContentPane().add(painel);
    }
}
