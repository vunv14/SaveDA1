/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Nguyễn Vũ
 */
@Data
@NoArgsConstructor
public class KhachHang {

    private Integer id;
    
    private String ten_kh;
    
    private Boolean gioi_tinh;
    
    private String sdt;
    
    private Boolean trang_thai;
}
