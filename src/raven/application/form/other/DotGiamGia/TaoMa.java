/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.DotGiamGia;

import java.util.Random;

/**
 *
 * @author DELL
 */
public class TaoMa {
    public static String generateCodeWithPrefix(String prefix, int numberLength) {
        Random random = new Random();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < numberLength; i++) {
            number.append(random.nextInt(10)); // Tạo số ngẫu nhiên từ 0-9 và thêm vào chuỗi
        }

        return prefix + number.toString();
    }
}
