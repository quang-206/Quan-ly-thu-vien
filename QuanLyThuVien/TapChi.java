/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;

/**
 *
 * @author Cao Phạm Nhật Quang
 */
public class TapChi extends TaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi(String maTaiLieu, String nhaXuatBan, int soLuongPhatHanh, 
                  int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, nhaXuatBan, soLuongPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }
    
    public int getSoPhatHanh(){
        return soPhatHanh;
    }
    public void setSoPhatHanh(int soPhatHanh){
        this.soPhatHanh = soPhatHanh;
    }
    
    public int getThangPhatHanh(){
        return thangPhatHanh;
    }
    public void setThangPhatHanh(int thangPhatHanh){
        this.thangPhatHanh = thangPhatHanh;
    }
}
