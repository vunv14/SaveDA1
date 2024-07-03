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
public class SanPham {

    private Integer id;
    
    private String ten_san_pham;
    
    private Integer so_luong;
    
    private String mo_ta;
    
    private Date create_at;
    
    private Date update_at;
    
    private Integer create_by;
    
    private Integer update_by;
    
    private Boolean trang_thai;
}
