/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Nguyễn Vũ
 */
@Data
@NoArgsConstructor
public class VaiTro {

    private Integer id;
    
    private Boolean gioi_tinh;
    
    private Date ngay_sinh;
    
    private String cccd;
    
    private String dia_chia;
    
    private String ho_ten;
    
    private Boolean trang_thai;
    
    private Boolean chuc_vu;
}
