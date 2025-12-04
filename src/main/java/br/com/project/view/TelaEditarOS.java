package br.com.project.view;

import br.com.project.service.EditarOS;
import javax.swing.*;
import java.sql.Timestamp;

/**
 * Tela para edição de Ordens de Serviço.
 * Desenvolvido por Venicio.
 */
public class TelaEditarOS extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaEditarOS.class.getName());

    public TelaEditarOS() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public void DadosOS(String NOS, String Data, String Equipamento, String defeito, String servico, String tecnico, String cliente, String valor, String status) {
        CampoNOS.setText(NOS);
        Campodata.setText(Data);
        CampoEquip.setText(Equipamento);
        CampoDefeito.setText(defeito);
        CampoServico.setText(servico);
        CampoCliente.setText(cliente);
        CampoTec.setText(tecnico);
        CampoStatus.setText(status);
        CampoValor.setText(valor);
    }

    private void BtSalvarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadastrarActionPerformed
        EditarOS editar = new EditarOS();
        editar.Editar(CampoNOS, Campodata, CampoEquip, CampoDefeito, CampoServico, CampoCliente, CampoTec, ComboBoxTipo, CampoValor);
    }//GEN-LAST:event_BtCadastrarActionPerformed

    /**
     * Inicialização automática dos componentes gráficos (gerado pelo NetBeans).
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ComboBoxTipo = new javax.swing.JComboBox<>();
        CampoEquip = new javax.swing.JTextField();
        CampoDefeito = new javax.swing.JTextField();
        CampoServico = new javax.swing.JTextField();
        CampoCliente = new javax.swing.JTextField();
        CampoStatus = new javax.swing.JTextField();
        CampoValor = new javax.swing.JTextField();
        CampoTec = new javax.swing.JTextField();
        Campodata = new javax.swing.JTextField();
        CampoNOS = new javax.swing.JTextField();
        BtSalvarEdicao = new javax.swing.JButton();
        BtSalvarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarEdicaoActionPerformed(evt);
            }
        });

        BtVoltar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar OS");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Editar Ordem de Serviço");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel2.setText("Nº OS:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel4.setText("Defeito:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel14.setText("DATA:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel5.setText("Equipamento:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel6.setText("Serviço:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel7.setText("Cliente:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel8.setText("Técnico Resp.:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel9.setText("Status");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel10.setText("Tipo:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel11.setText("Valor:");

        ComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
                "Concluido", "Orçamento aprovado", "Aguardando aprovação",
                "Aguardando peças", "Abandonado pelo cliente", "Na bancada", "Retornou"
        }));

        BtSalvarEdicao.setFont(new java.awt.Font("Segoe UI", 1, 12));
        BtSalvarEdicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/botao-salvar.png")));
        BtSalvarEdicao.setText("Salvar Alterações");

        BtVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        BtVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/desfazer.png")));
        BtVoltar.setText("Voltar");

        BtCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/cancelar.png")));
        BtCancelar.setText("Cancelar");

        // Layout gerado automaticamente
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoNOS, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Campodata))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoEquip))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoDefeito))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoServico))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoCliente))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoTec))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoStatus))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CampoValor))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(BtSalvarEdicao)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BtVoltar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BtCancelar)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(CampoNOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)
                                        .addComponent(Campodata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(CampoEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(CampoDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(CampoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(CampoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(CampoTec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(ComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(CampoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(CampoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BtSalvarEdicao)
                                        .addComponent(BtVoltar)
                                        .addComponent(BtCancelar))
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        pack();
    }

    public void GetInfoOs(Timestamp Data, JTextField Equipamento, JTextField Defeito,
                          JTextField Servico, JTextField Cliente, JTextField Tecnico,
                          JTextField Status, JTextField valor) {
        // Método reservado para futuras implementações
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaEditarOS().setVisible(true));
    }

    // Declaração dos componentes
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtSalvarEdicao;
    private javax.swing.JButton BtVoltar;
    private javax.swing.JTextField CampoCliente;
    private javax.swing.JTextField CampoDefeito;
    private javax.swing.JTextField CampoEquip;
    private javax.swing.JTextField CampoNOS;
    private javax.swing.JTextField CampoServico;
    private javax.swing.JTextField CampoStatus;
    private javax.swing.JTextField CampoTec;
    private javax.swing.JTextField CampoValor;
    private javax.swing.JTextField Campodata;
    private javax.swing.JComboBox<String> ComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
}
