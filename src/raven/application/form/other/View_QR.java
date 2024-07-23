package raven.application.form.other;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class View_QR extends javax.swing.JDialog {

  private VideoCapture camera;
    private static final int CAPTURE_INTERVAL = 400;
    public static String maQR;
    private static boolean shouldScan = true;
    private Timer timer;

    static {
        System.setProperty("java.library.path", "C:\\jar_files (10)\\opencv-3.4.1-1.4.1.jar");
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public View_QR() {
        initComponents();
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        initializeComboBox();
        initializeCamera();
    }

    private void initializeComboBox() {
        jComboBox1.addItem("Camera máy tính");
        jComboBox1.addItem("Camera iVcame");
        jComboBox1.setSelectedIndex(0);
    }

    private void initializeCamera() {
        int cameraIndex = jComboBox1.getSelectedIndex();
        camera = new VideoCapture(cameraIndex); // Sử dụng camera được chọn
        if (!camera.isOpened()) {
            JOptionPane.showMessageDialog(this, "Camera không hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        startCaptureWorker();
    }

    private void startCaptureWorker() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(CAPTURE_INTERVAL, e -> captureAndDecode());
        timer.start();
    }

    private void captureAndDecode() {
        Mat frame = new Mat();
        if (!camera.read(frame)) {
            return;
        }

        BufferedImage image = matToBufferedImage(frame);
        if (image != null) {
            processImage(image);
        }
    }

    private BufferedImage matToBufferedImage(Mat mat) {
        int width = mat.width();
        int height = mat.height();
        int channels = mat.channels();
        byte[] sourcePixels = new byte[width * height * channels];
        mat.get(0, 0, sourcePixels);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);
        return image;
    }

    private void processImage(BufferedImage img) {
        LuminanceSource source = new BufferedImageLuminanceSource(img);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            maQR = result.getText();
            if (!maQR.isBlank()) {
                JOptionPane.showMessageDialog(this, "Mã QR: " + maQR);
                shouldScan = false; // Dừng quét sau khi quét được mã QR
                if (timer != null) {
                    timer.stop();
                }
            }
        } catch (NotFoundException ignored) {
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        if (camera != null && camera.isOpened()) {
            camera.release();
        }
        if (timer != null) {
            timer.stop();
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Đổi camera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (timer != null) {
            timer.stop();
        }
        if (camera != null && camera.isOpened()) {
            camera.release();
        }
        initializeCamera();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
