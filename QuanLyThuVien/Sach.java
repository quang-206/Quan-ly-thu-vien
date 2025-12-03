/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;

/**
 *
 * @author Cao Phạm Nhật Quang
 */
public class Sach extends TaiLieu{
    private String tenTacGia;
    private int soTrang;
    private String theLoai;

    public Sach(String maTaiLieu, String nhaXuatBan, int soLuongPhatHanh, 
                String tenTacGia, int soTrang, String theLoai) {
        super(maTaiLieu, nhaXuatBan, soLuongPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
        this.theLoai = theLoai;
    }
    
    public String getTenTacGia(){
        return tenTacGia;
    }
    public void setTenTacGia(String tenTacGia){
        this.tenTacGia = tenTacGia;
    }
    
    public int getSoTrang(){
        return soTrang;
    }
    public void setSoTrang(int soTrang){
        this.soTrang = soTrang;
    }
    
    public String getTheLoai(){
        return theLoai;
    }
    public void setTheLoai(String theLoai){
        this.theLoai = theLoai;
    }
}
