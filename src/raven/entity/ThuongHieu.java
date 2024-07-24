/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThuongHieu {

    private Integer id;
    
    private String ma;
    
    private String thuongHieu;
    
    private Boolean trangThai;

    public ThuongHieu(String ma, String thuongHieu, Boolean trangThai) {
        this.ma = ma;
        this.thuongHieu = thuongHieu;
        this.trangThai = trangThai;
    }
    
    
}
