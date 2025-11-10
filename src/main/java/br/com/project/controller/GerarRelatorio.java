package br.com.project.controller;

import br.com.project.dao.Dao;
import jakarta.persistence.TypedQuery;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;

import javax.swing.*;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class GerarRelatorio {

    public static void GerarRelatorio(String caminho, String Nome_De_Arquivo_Salvo, JTextField dataInicio, JTextField dataFim) {
        Dao conexao = new Dao();
        try {
            conexao.IniciarConexao();

            // Converte datas
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataI = LocalDate.parse(dataInicio.getText(), formatador);
            LocalDate dataF = LocalDate.parse(dataFim.getText(), formatador);

            // Verifica se existem registros no período
            String jpql = "SELECT COUNT(o) FROM OrdensDeServico o WHERE o.data_os BETWEEN :dataI AND :dataF";
            TypedQuery<Long> query = conexao.em.createQuery(jpql, Long.class);
            query.setParameter("dataI", java.sql.Timestamp.valueOf(dataI.atStartOfDay()));
            query.setParameter("dataF", java.sql.Timestamp.valueOf(dataF.atStartOfDay()));

            Long total = query.getSingleResult();
            if (total == 0) {
                JOptionPane.showMessageDialog(null,
                        "Nenhuma Ordem de Serviço encontrada no período selecionado.",
                        "Aviso",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Carrega o arquivo do relatório
            InputStream LocalArquivo = GerarRelatorio.class.getResourceAsStream(caminho);
            if (LocalArquivo == null) {
                throw new RuntimeException("⚠️ Arquivo de relatório não encontrado: " + caminho);
            }

            JasperReport report;
            if (caminho.endsWith(".jrxml")) {
                report = JasperCompileManager.compileReport(LocalArquivo);
            } else if (caminho.endsWith(".jasper")) {
                report = (JasperReport) JRLoader.loadObject(LocalArquivo);
            } else {
                throw new RuntimeException("Extensão inválida para relatório: " + caminho);
            }

            // Parâmetros (confirme os nomes no seu .jrxml)
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("dataInicio", java.sql.Date.valueOf(dataI));
            parametros.put("dataFim", java.sql.Date.valueOf(dataF));

            // Gera o relatório
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conexao.getConnection());
            JasperExportManager.exportReportToPdfFile(print, Nome_De_Arquivo_Salvo);

            System.out.println("✅ Relatório gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace(); // Mostra o erro completo
        } finally {
            conexao.FecharConexao(); // Fecha conexões sempre
        }
    }
}