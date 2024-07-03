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
public class KichThuoc {

    private Integer id;
    
    private String size;
    
    private Double rong_ao;
    
    private Double dai_ao;
    
    private Double rong_vai;
    
    private Double dai_tay;
}