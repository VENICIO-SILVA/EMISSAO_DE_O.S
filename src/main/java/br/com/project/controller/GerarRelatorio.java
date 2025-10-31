package br.com.project.controller;

import br.com.project.dao.Dao;
import net.sf.jasperreports.engine.*;

import javax.swing.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class GerarRelatorio {
    public static void gerarRelatorio() {
    Dao conexao = new Dao();
        try {

            InputStream caminho = GerarRelatorio.class.getResourceAsStream("/relatorios/BaseRelatorioO.S.jrxml");

            if (caminho == null) {
                System.out.println("⚠️ Arquivo .jrxml não encontrado!");
                return;
            }

            JasperReport report = JasperCompileManager.compileReport(caminho);

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("TITULO", "Relatório de Serviços");


            JasperPrint print = JasperFillManager.fillReport(report, parametros, conexao.getConnection());

            JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Venicio\\Desktop\\RELATORIOos\\Relatorio_de_Serviços.pdf");
            System.out.println("✅ Relatório gerado com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,"Erro de conexão com banco de dados" + e.getMessage());
        }
    }
}
