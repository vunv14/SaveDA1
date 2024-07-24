/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.sanpham.QR;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import raven.application.form.other.sanpham.repository.RepositorySanPhamCT;

/**
 *
 * @author Nguyễn Vũ
 */
public class SanPhamCTQRCode extends javax.swing.JDialog implements Runnable, ThreadFactory {
    
    
    public static String maSPCT;
    private WebcamPanel panel = null;
    private Webcam webCam  = null;
      private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    RepositorySanPhamCT spctd = new RepositorySanPhamCT();
    
    
    

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Thread newThread(Runnable r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
