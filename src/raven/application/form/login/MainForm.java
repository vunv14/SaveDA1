package raven.application.form.login;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import raven.application.Application;
import raven.application.form.other.BanHang.BanHang_View;
import raven.application.form.other.DoiMatKhau.DoiMatKhau;
import raven.application.form.other.FormDashboard;
import raven.application.form.other.FormInbox;
import raven.application.form.other.FormRead;
import raven.application.form.other.DotGiamGia.FormDotGiamGia;
import raven.application.form.other.VaiTro.NhanVien_View;
import raven.application.form.other.hoadon.FormHoaDon;
import raven.application.form.other.khachhang.ViewKhachHang;
import raven.application.form.other.phieuGiamGia.View;
import raven.application.form.other.sanpham.view.Viewsanpham;
import raven.application.form.other.thongke.ThongKeForm;
import raven.application.form.other.thuoctinh.chatlieu.ViewChatLieu;
import raven.application.form.other.thuoctinh.kichthuoc.view.ViewKichThuoc;
import raven.application.form.other.thuoctinh.kieuao.ViewKieuAo;
import raven.application.form.other.thuoctinh.mau.ViewMau;
import raven.application.form.other.thuoctinh.thuonghieu.ViewThuongHieu;
import raven.application.form.other.thuoctinh.xuatxu.ViewXuatXu;
import raven.entity.VaiTro;

import raven.menu.Menu;
import raven.menu.MenuAction;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class MainForm extends JLayeredPane {

    public MainForm() {
        init();
    }
    boolean check1 = true;
    boolean check2 = true;

    private void init() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new MainFormLayout());
        menu = new Menu();
        panelBody = new JPanel(new BorderLayout());
        initMenuArrowIcon();
        menuButton.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.button.background;"
                + "arc:999;"
                + "focusWidth:0;"
                + "borderWidth:0");
        menuButton.addActionListener((ActionEvent e) -> {
            setMenuFull(!menu.isMenuFull());
        });
        initMenuEvent();
        setLayer(menuButton, JLayeredPane.POPUP_LAYER);
        add(menuButton);
        add(menu);
        add(panelBody);
    }

    @Override
    public void applyComponentOrientation(ComponentOrientation o) {
        super.applyComponentOrientation(o);
        initMenuArrowIcon();
    }

    private void initMenuArrowIcon() {
        if (menuButton == null) {
            menuButton = new JButton();
        }
        String icon = (getComponentOrientation().isLeftToRight()) ? "menu_left.svg" : "menu_right.svg";
        menuButton.setIcon(new FlatSVGIcon("raven/icon/svg/" + icon, 0.8f));
    }

    private void initMenuEvent() {
        menu.addMenuEvent((int index, int subIndex, MenuAction action) -> {
            // Application.mainForm.showForm(new DefaultForm("Form : " + index + " " + subIndex));
            VaiTro currentUser = Application.getCurrentUser();

       

//            if (currentUser.getChucVu()) {
//                if (check1) {
//                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đăng nhập với tư cách quản lí");
//                    check1 = false;
//                }
//                if (index == 0) {
//                    Application.showForm(new FormDashboard());
//                } else if (index == 1) {
//
//                } else if (index == 4) {
//                    if (subIndex == 1) {
//                    } else {
//                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Lỗi");
//                    }
//                } else if (index == 10) {
//                     Application.showForm(new FormDoiMatKhau());
//                }
//                
//            }
            if (currentUser.getChucVu()) {
                if (check1) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đăng nhập với tư cách quản lí");
                    check1 = false;
                }
                if (index == 111) {
                    Application.showForm(new FormDashboard());
                } else if (index == 0) {
                    Application.showForm(new Viewsanpham());
                }else if(index == 1){
                   if(subIndex == 1){
                       Application.showForm(new ViewXuatXu());
                   }else if( subIndex == 2){
                       Application.showForm(new ViewKichThuoc());
                   }else if( subIndex == 3){
                       Application.showForm(new ViewThuongHieu());
                   }else if( subIndex == 4){
                       Application.showForm(new ViewChatLieu());
                   }else if( subIndex == 5){
                       Application.showForm(new ViewKieuAo());

                   }else if( subIndex == 6){
                       Application.showForm(new ViewMau());
                   }
                }
                else if(index == 2){
                    Application.showForm(new NhanVien_View());
                }
                else if(index == 3){
                    Application.showForm(new BanHang_View());
                }
                else if(index == 4){
                    Application.showForm(new FormHoaDon());
                }
                else if(index == 5){
                        Application.showForm(new ViewKhachHang());
                }
                else if(index == 6){
                      Application.showForm(new View());
                }
                else if(index == 7){
                        Application.showForm(new FormDotGiamGia());
                } else if(index == 8){
                        Application.showForm(new ThongKeForm());
                }
                
                
                
                else if(index == 5){
                    Application.showForm(new FormHoaDon());
                }else if (index == 9) {
                   new DoiMatKhau().setVisible(true);
                } else if(index == 10){
                  Application.logout();
                }
            } else {
                if (check2) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đăng nhập với tư cách nhan vien");
                    check2 = false;
                }
                if (index == 0) {
                    Application.showForm(new FormDashboard());
                } else if (index == 1) {

                    Application.showForm(new FormDashboard());
                } else if (index == 11) {
                    Application.logout();
                } else {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Nhan Vien không thể bấm vào được");

                }
            }
        });
    
        }
                
    private void setMenuFull(boolean full) {
        String icon;
        if (getComponentOrientation().isLeftToRight()) {
            icon = (full) ? "menu_left.svg" : "menu_right.svg";
        } else {
            icon = (full) ? "menu_right.svg" : "menu_left.svg";
        }
        menuButton.setIcon(new FlatSVGIcon("raven/icon/svg/" + icon, 0.8f));
        menu.setMenuFull(full);
        revalidate();
    }

    public void hideMenu() {
        menu.hideMenuItem();
    }

    public void showForm(Component component) {
        panelBody.removeAll();
        panelBody.add(component);
        panelBody.repaint();
        panelBody.revalidate();
    }

    public void setSelectedMenu(int index, int subIndex) {
        menu.setSelectedMenu(index, subIndex);
    }

    private Menu menu;
    private JPanel panelBody;
    private JButton menuButton;

    private class MainFormLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
boolean ltr = parent.getComponentOrientation().isLeftToRight();
                Insets insets = UIScale.scale(parent.getInsets());
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int menuWidth = UIScale.scale(menu.isMenuFull() ? menu.getMenuMaxWidth() : menu.getMenuMinWidth());
                int menuX = ltr ? x : x + width - menuWidth;
                menu.setBounds(menuX, y, menuWidth, height);
                int menuButtonWidth = menuButton.getPreferredSize().width;
                int menuButtonHeight = menuButton.getPreferredSize().height;
                int menubX;
                if (ltr) {
                    menubX = (int) (x + menuWidth - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.3f)));
                } else {
                    menubX = (int) (menuX - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.7f)));
                }
                menuButton.setBounds(menubX, UIScale.scale(30), menuButtonWidth, menuButtonHeight);
                int gap = UIScale.scale(5);
                int bodyWidth = width - menuWidth - gap;
                int bodyHeight = height;
                int bodyx = ltr ? (x + menuWidth + gap) : x;
                int bodyy = y;
                panelBody.setBounds(bodyx, bodyy, bodyWidth, bodyHeight);
            }
        }
    }
}
