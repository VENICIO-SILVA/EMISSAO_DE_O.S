package br.com.project.controller;

import br.com.project.dao.Dao;
import jakarta.persistence.TypedQuery;
import net.sf.jasperreports.engine.*;

import javax.swing.*;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class GerarRelatorio {

    public static void GerarRelatorio(String Tipo_Relatorio, String caminho, String nomeArquivoSaida,
                                      JTextField dataInicio, JTextField dataFim) {

        Dao conexao = new Dao();
        InputStream localArquivo = null;


        try {
            conexao.IniciarConexao();

            switch (Tipo_Relatorio) {
                case "Ordens":
                    //todo colocar no relatorio o tipo de ordem se é orçamento ou orden
                    // Converte as datas do JTextField
                    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataI = LocalDate.parse(dataInicio.getText(), formatador);
                    LocalDate dataF = LocalDate.parse(dataFim.getText(), formatador);


                    // Confere se há OS no período
                    String jpql = "SELECT COUNT(o) FROM OrdensDeServico o WHERE o.data_os BETWEEN :dataI AND :dataF";
                    TypedQuery<Long> query = conexao.em.createQuery(jpql, Long.class);
                    query.setParameter("dataI", java.sql.Timestamp.valueOf(dataI.atStartOfDay()));
                    query.setParameter("dataF", java.sql.Timestamp.valueOf(dataF.atStartOfDay()));
                    Long total = query.getSingleResult();

                    if (total == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Nenhuma Ordem de Serviço encontrada no período selecionado.",
                                "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    // Carrega o relatório do resources
                    localArquivo = GerarRelatorio.class.getResourceAsStream(caminho);

                    if (localArquivo == null) {
                        throw new RuntimeException("Arquivo de relatório não encontrado no caminho: " + caminho);
                    }

                    // Compila o .jrxml
                    JasperReport report = JasperCompileManager.compileReport(localArquivo);

                    // Cria os parâmetros do relatório
                    Map<String, Object> parametros = new HashMap<>();
                    parametros.put("dataInicio", java.sql.Date.valueOf(dataI));
                    parametros.put("dataFim", java.sql.Date.valueOf(dataF));

                    // Preenche o relatório
                    JasperPrint print = JasperFillManager.fillReport(report, parametros, conexao.getConnection());

                    // Exporta o PDF
                    JasperExportManager.exportReportToPdfFile(print, nomeArquivoSaida);
                    JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");

                    System.out.println("✅ PDF salvo em: " + nomeArquivoSaida);
                    break;

                case "Clientes":
                    // Converte as datas do JTextField
                    DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataI2 = LocalDate.parse(dataInicio.getText(), formatador2);
                    LocalDate dataF2 = LocalDate.parse(dataFim.getText(), formatador2);


                    // Confere se cliente  no período
                    String jpql2 = "SELECT COUNT(o) FROM Clientes  o WHERE o.data_cadastro BETWEEN :dataI AND :dataF";
                    TypedQuery<Long> query2 = conexao.em.createQuery(jpql2, Long.class);
                    query2.setParameter("dataI", java.sql.Date.valueOf(dataI2));
                    query2.setParameter("dataF", java.sql.Date.valueOf(dataF2));
                    Long total2 = query2.getSingleResult();

                    if (total2 == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Nenhum Cliente encontrada no período selecionado.",
                                "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    // Carrega o relatório do resources
                    localArquivo = GerarRelatorio.class.getResourceAsStream(caminho);

                    if (localArquivo == null) {
                        throw new RuntimeException("Arquivo de relatório não encontrado no caminho: " + caminho);
                    }

                    // Compila o .jrxml
                    JasperReport report2 = JasperCompileManager.compileReport(localArquivo);

                    // Cria os parâmetros do relatório
                    Map<String, Object> parametros2 = new HashMap<>();
                    parametros2.put("dataInicio", java.sql.Date.valueOf(dataI2));
                    parametros2.put("dataFim", java.sql.Date.valueOf(dataF2));

                    // Preenche o relatório
                    JasperPrint print2 = JasperFillManager.fillReport(report2, parametros2, conexao.getConnection());

                    // Exporta o PDF
                    JasperExportManager.exportReportToPdfFile(print2, nomeArquivoSaida);
                    JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");

                    System.out.println("✅ PDF salvo em: " + nomeArquivoSaida);
                    break;

                case "Valores":
                    DateTimeFormatter formatador3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataI3 = LocalDate.parse(dataInicio.getText(), formatador3);
                    LocalDate dataF3 = LocalDate.parse(dataFim.getText(), formatador3);


                    // Confere se há valores no período
                    String jpql3 = "SELECT COUNT(o) FROM OrdensDeServico o " +
                            "WHERE o.status = :status " +
                            "AND o.data_os BETWEEN :dataI AND :dataF";
                    TypedQuery<Long> query3 = conexao.em.createQuery(jpql3, Long.class);
                    query3.setParameter("status", "Concluido");
                    query3.setParameter("dataI", java.sql.Timestamp.valueOf(dataI3.atStartOfDay()));
                    query3.setParameter("dataF", java.sql.Timestamp.valueOf(dataF3.atStartOfDay()));
                    Long total3 = query3.getSingleResult();

                    if (total3 == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Nenhum Valor encontrada no período selecionado.",
                                "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    // Carrega o relatório do resources
                    localArquivo = GerarRelatorio.class.getResourceAsStream(caminho);

                    if (localArquivo == null) {
                        throw new RuntimeException("Arquivo de relatório não encontrado no caminho: " + caminho);
                    }

                    // Compila o .jrxml
                    JasperReport report3 = JasperCompileManager.compileReport(localArquivo);

                    // Cria os parâmetros do relatório
                    Map<String, Object> parametros3 = new HashMap<>();
                    parametros3.put("dataInicio", java.sql.Date.valueOf(dataI3));
                    parametros3.put("dataFim", java.sql.Date.valueOf(dataF3));

                    // Preenche o relatório
                    JasperPrint print3 = JasperFillManager.fillReport(report3, parametros3, conexao.getConnection());

                    // Exporta o PDF
                    JasperExportManager.exportReportToPdfFile(print3, nomeArquivoSaida);
                    JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");

                    System.out.println("✅ PDF salvo em: " + nomeArquivoSaida);

                    break;

            }


        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório:\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.FecharConexao();
        }
    }
}
