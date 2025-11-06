package br.com.project.controller;

import br.com.project.dao.Dao;
import net.sf.jasperreports.engine.*;

import javax.swing.*;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class GerarRelatorio {

    //esse parametro vai servir para quando iniciar o relatorio enviar o caminho correto para gerar o relatorio correto
    //pois existem 3 tipos. 1- clientes, 2-ordens, 3-valores

    public static void GerarRelatorio(String caminho, String Nome_De_Arquivo_Salvo, JTextField dataInicio, JTextField dataFim) {
    Dao conexao = new Dao();
        try {
            conexao.IniciarConexao();

            //como os campos vem da tela como "Jtextfield e necessario
            //a conversao para DATA
            //todo provavelmente  as VAR dataI e dataF nao estao recebendo as datas vindas dos parametros
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataI = LocalDate.parse(dataInicio.getText());
            LocalDate dataF = LocalDate.parse(dataFim.getText());

            // Verifica se existem OS dentro do período selecionado
            String sql = "SELECT COUNT(*) AS total FROM os WHERE data_os BETWEEN ? AND ?";
            PreparedStatement pst = conexao.em.unwrap(java.sql.Connection.class).prepareStatement(sql);
            pst.setDate(1, java.sql.Date.valueOf(dataI));
            pst.setDate(2, java.sql.Date.valueOf(dataF));
            ResultSet rs = pst.executeQuery();

            if (rs.next() && rs.getInt("total") == 0) {
                JOptionPane.showMessageDialog(null,
                        "Nenhuma Ordem de Serviço encontrada no período selecionado.",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
                conexao.FecharConexao();
                return;
            }
            //procura o arquivo no projeto
            InputStream LocalArquivo = GerarRelatorio.class.getResourceAsStream(caminho);

            //verifica se o arquivo existe
            if (LocalArquivo == null) {
                System.out.println("⚠️ Arquivo .jrxml não encontrado!");
                return;
            }
            //faz a conversao do arquivo encontrado para objeto java para que o Jasper Entenda o arquivo
            JasperReport report = JasperCompileManager.compileReport(LocalArquivo);

            //todo no momento nao tem uso, mas irei utulizar para inserir dados complementares no PDF
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dataInicio", java.sql.Date.valueOf(dataI));
            parametros.put("dataFim", java.sql.Date.valueOf(dataF));


            JasperPrint print = JasperFillManager.fillReport(report, parametros, conexao.getConnection());

            JasperExportManager.exportReportToPdfFile(print, Nome_De_Arquivo_Salvo);
            System.out.println("✅ Relatório gerado com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,"Erro de conexão com banco de dados" + e.getMessage());
        }
    }
}
