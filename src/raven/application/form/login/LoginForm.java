package raven.application.form.login;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import raven.application.Application;
import raven.entity.VaiTro;
import raven.toast.Notifications;
import java.util.ArrayList;
import java.util.List;
import raven.application.form.other.VaiTro.repository.RepositoryNhanVien;

/**
 *
 * @author Raven
 */
public class LoginForm extends javax.swing.JPanel {

    public LoginForm() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("al center center"));

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");

        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "User Name");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new raven.application.form.login.PanelLogin();
        lbTitle = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lbPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Login");
        panelLogin1.add(lbTitle);

        lbUser.setText("User Name");
        panelLogin1.add(lbUser);

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        panelLogin1.add(txtUser);

        lbPass.setText("Password");
        panelLogin1.add(lbPass);

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        panelLogin1.add(txtPass);

        cmdLogin.setText("Login");
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });
        panelLogin1.add(cmdLogin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
//
//        if (txtUser.getText().isEmpty()) {
//            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Vui lòng nhập user");
//            txtPass.requestFocus();
//        }
//
//        if (txtUser.getText().isEmpty()) {
//            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Vui lòng nhập password");
//            txtUser.requestFocus();
//        }
//
//        List<VaiTro> list = new RepositoryNhanVien().getAllLG();
//        for (VaiTro vaiTro : list) {
//            if (txtUser.getText().equalsIgnoreCase(vaiTro.getHo_ten())) {
//                if (txtPass.getText().equalsIgnoreCase(vaiTro.getMa_khau())) {
//                    if (vaiTro.getChuc_vu()) {
//                        Application.login();
//                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Hoan hô giỏi quá. Đăng nhập thành công!");
//                    } else {
//                        Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Sai tài khoản hoặc mật khẩu!");
//                    }
//                }
//            }
//        }

 if (txtUser.getText().isEmpty() || txtPass.getText().isEmpty()) {
        Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Vui lòng nhập user và password");
        return;
    }

    List<VaiTro> list = new RepositoryNhanVien().getAllLG();
    boolean loggedIn = false;
    for (VaiTro vaiTro : list) {
        if (txtUser.getText().equalsIgnoreCase(vaiTro.getHo_ten()) && txtPass.getText().equalsIgnoreCase(vaiTro.getMa_khau())) {
            loggedIn = true;
            // Save current user's role for permission checking
            Application.setCurrentUser(vaiTro);
            break;
        }
    }

    if (loggedIn) {
        Application.login();
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đăng nhập thành công!");
    } else {
        Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Sai tài khoản hoặc mật khẩu!");
    }


    }//GEN-LAST:event_cmdLoginActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdLogin;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private raven.application.form.login.PanelLogin panelLogin1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
