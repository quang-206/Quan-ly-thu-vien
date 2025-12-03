/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;
import java.util.Date;

/**
 *
 * @author Cao Phạm Nhật Quang
 */
public class Bao extends TaiLieu {
    private Date ngayPhatHanh;

    public Bao(String maTaiLieu, String nhaXuatBan, int soLuongPhatHanh, Date ngayPhatHanh) {
        super(maTaiLieu, nhaXuatBan, soLuongPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }
    
    public Date getNgayPhatHanh(){
        return ngayPhatHanh;
    }
    public void setNgayPhatHanh(Date ngayPhatHanh){
        this.ngayPhatHanh = ngayPhatHanh;
    }
}
