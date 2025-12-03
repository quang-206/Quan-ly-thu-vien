/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;

/**
 *
 * @author Cao Phạm Nhật Quang
 */
public class ThanhVien extends Person {
    private String maThanhVien;
    
    
    public ThanhVien(String maThanhVien, String hoTen, String soDienThoai, String email){
        super(hoTen, soDienThoai, email);
        this.maThanhVien = maThanhVien;
    }
    
    public String getMaThanhVien(){
        return maThanhVien;
    }
    public void setMaThanhVien(String maThanhVien){
        this.maThanhVien = maThanhVien;
    }
    @Override
    public String toString(){
        return "ThanhVien{" + "ma" + maThanhVien + ", ten =" + hoTen +'}';
    }
}
