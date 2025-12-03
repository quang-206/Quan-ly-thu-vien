/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;

/**
 *
 * @author Cao Phạm Nhật Quang
 */
public class NhanVien extends Person {
    private String maNhanVien;
    private String chucVu;

    public NhanVien(String maNhanVien, String hoTen, String soDienThoai, String email, String chucVu) {
        super(hoTen, soDienThoai, email);
        this.maNhanVien = maNhanVien;
        this.chucVu = chucVu;
    }

    public String getMaNhanVien() {
        return maNhanVien; 
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien; 
    }
    public String getChucVu() {
        return chucVu; 
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu; 
    }
}
