package br.com.project.controller;

import br.com.project.dao.Dao;
import net.sf.jasperreports.engine.*;

import javax.swing.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class GerarRelatorio {

    //esse parametro vai servir para quando iniciar o relatorio enviar o caminho correto para gerar o relatorio correto
    //pois existem 3 tipos. 1- clientes, 2-ordens, 3-valores

    public static void GerarRelatorio(String caminho, String Nome_De_Arquivo_Salvo) {
    Dao conexao = new Dao();
        try {
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
            parametros.put("TITULO", "Relatório de Serviços");


            JasperPrint print = JasperFillManager.fillReport(report, parametros, conexao.getConnection());

            JasperExportManager.exportReportToPdfFile(print, Nome_De_Arquivo_Salvo);
            System.out.println("✅ Relatório gerado com sucesso!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,"Erro de conexão com banco de dados" + e.getMessage());
        }
    }
}
