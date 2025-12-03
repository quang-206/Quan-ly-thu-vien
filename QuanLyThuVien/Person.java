/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;

/**
 *
 * @author Cao Phạm Nhật Quang
 */
public abstract class Person {
    protected String hoTen;
    protected String soDienThoai;
    protected String email;
    
    public Person (String hoTen, String soDienThoai, String email){
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }
    
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }
    
    public String getSoDienThoai(){
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai){
        this.soDienThoai = soDienThoai;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
