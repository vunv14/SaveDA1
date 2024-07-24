/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class XuatXu {

    private Integer id;

    private String ma;

    private String diaChi;

    private Boolean trangThai;

    public XuatXu(String ma, String diaChi) {
        this.ma = ma;
        this.diaChi = diaChi;
    }

}
