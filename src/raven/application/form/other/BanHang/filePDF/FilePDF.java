/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.BanHang.filePDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import raven.entity.HoaDon;

/**
 *
 * @author Nguyễn Vũ
 */
public class FilePDF {
    
    public static void exportTableToPdf(JTable table, HoaDon hoaDon, String fileName) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            // Thêm thông tin hóa đơn vào PDF
            document.add(new Paragraph("----------------------------------------"));
            document.add(new Paragraph("        NOON TSHIRT        "));
            document.add(new Paragraph("               Địa Chỉ:       "));
            document.add(new Paragraph(" P. Kiều Mai, Phúc Diễn, Từ Liêm, Hà Nội"));
            document.add(new Paragraph("      www.facebook.com/NVV  "));
            document.add(new Paragraph("            +84375361435       "));
            document.add(new Paragraph("----------------------------------------"));
            document.add(new Paragraph(""));
            
            
                document.add(new Paragraph("Tổng tiền " + hoaDon.getTongTien()));
            document.add(new Paragraph("Hóa đơn ID: " + hoaDon.getId()));
            document.add(new Paragraph("Khách hàng: " + hoaDon.getKh().getTenKh()));
            document.add(new Paragraph("Ngày: " + hoaDon.getCreateAt())); 
            document.add(new Paragraph("----------------------------------------"));
            document.add(new Paragraph(""));
            document.close();

            JOptionPane.showMessageDialog(null, "PDF created successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);

            // Mở file PDF
            File pdfFile = new File(fileName);
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            }

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to create PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}