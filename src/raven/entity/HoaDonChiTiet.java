/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import lombok.Data;

@Data

/**
 *
 * @author Nguyễn Vũ
 */

public class HoaDonChiTiet {

    private Integer id;
    
    private Integer id_spct;
    
    private Integer id_hoa_don;
    
    private Integer so_luong;
    
    private Double gia;
    
    private Boolean trang_thai;
}
