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
 //todo criar outro jrxml e configura manual com o aprendizado e ordem de tags
public class GerarRelatorio {

    public static void GerarRelatorio(String caminho, String nomeArquivoSaida,
                                      JTextField dataInicio, JTextField dataFim) {

        Dao conexao = new Dao();
        InputStream localArquivo = null;

        try {
            conexao.IniciarConexao();

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
            JOptionPane.showMessageDialog(null, "✅ Relatório gerado com sucesso!");

            System.out.println("✅ PDF salvo em: " + nomeArquivoSaida);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório:\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.FecharConexao();
        }
    }
}
