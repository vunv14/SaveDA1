/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

//import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Data

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Mau {

    private Integer id;
    
    private String ma;
    
    private String loaiMau;
    
    private Boolean trangThai;

    public Mau(String ma, String loaiMau) {
        this.ma = ma;
        this.loaiMau = loaiMau;
    }
    
    
}

