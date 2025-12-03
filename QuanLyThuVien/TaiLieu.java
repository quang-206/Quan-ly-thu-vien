/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;

/**
 *
 * @author Cao Phạm Nhật Quang
 */
public abstract class TaiLieu {
    protected String maTaiLieu;
    protected String nhaXuatBan;
    protected int soLuongPhatHanh;

    public TaiLieu(String maTaiLieu, String nhaXuatBan, int soLuongPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.nhaXuatBan = nhaXuatBan;
        this.soLuongPhatHanh = soLuongPhatHanh;
    }
    
    public String getMaTaiLieu(){
        return maTaiLieu;
    }
    public void settMaTaiLieu(String maTaiLieu){
        this.maTaiLieu = maTaiLieu;
    }
    
    public String getNhaXuatBan(){
        return nhaXuatBan;
    }
    public void setNhaXuatBan(String nhaXuatBan){
        this.nhaXuatBan = nhaXuatBan;
    }
    
    public int getSoLuongPhatHanh(){
        return soLuongPhatHanh;
    }
    public void setSoLuongPhatHanh(int soLuongPhatHanh){
        this.soLuongPhatHanh = soLuongPhatHanh;
    }
}
