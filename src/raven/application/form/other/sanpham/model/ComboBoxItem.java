/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.sanpham.model;

/**
 *
 * @author Nguyễn Vũ
 */
public class ComboBoxItem {
    private int id;
    private String description;

    public ComboBoxItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return description; // Phương thức này giúp hiển thị mô tả trong JComboBox
    }
}
