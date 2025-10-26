package br.com.project.controller;

import br.com.project.dao.Dao;
import br.com.project.domain.OrdensDeServico;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

public class GerarPdf {

    public void gerar(String idOs) {
        Dao conexao = new Dao();
        conexao.IniciarConexao();

        try {
            // Busca a OS pelo número
            OrdensDeServico os = conexao.em.find(OrdensDeServico.class, Integer.parseInt(idOs));

            if (os == null) {
                throw new Exception("Ordem de Serviço não encontrada!");
            }

            //Caminho do arquivo
            String caminho = System.getProperty("user.home") + "/Desktop/OS_" + idOs + ".pdf";

            //Cria documento
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(caminho));
            document.open();

            //Título
            Font tituloFont = new Font(Font.HELVETICA, 20, Font.BOLD);
            Paragraph titulo = new Paragraph("Ordem de Serviço Nº " + os.getOs(), tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            document.add(new Paragraph("\n"));

            Font corpoFont = new Font(Font.HELVETICA, 18, Font.NORMAL);
            document.add(new Paragraph("RELATÓRIO DE SERVIÇO", corpoFont));
            document.add(new Paragraph("Data: " + os.getData_os(), corpoFont));
            document.add(new Paragraph("Cliente: " + os.getCliente().getNome(), corpoFont));
            document.add(new Paragraph("Equipamento: " + os.getEquipamento(), corpoFont));
            document.add(new Paragraph("Defeito: " + os.getDefeito(), corpoFont));
            document.add(new Paragraph("Serviço: " + os.getServico(), corpoFont));
            document.add(new Paragraph("Técnico Responsável: " + os.getTecnico(), corpoFont));
            document.add(new Paragraph("Tipo: " + os.getTipo(), corpoFont));
            document.add(new Paragraph("Status: " + os.getStatus(), corpoFont));
            document.add(new Paragraph("Valor: R$ " + os.getValor(), corpoFont));

            document.close();
            conexao.FecharConexao();

            //abre o pdf no navegador
            Desktop.getDesktop().browse(new File(caminho).toURI());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar PDF: " + e.getMessage());
        } finally {
            conexao.FecharConexao();
        }
    }
}
