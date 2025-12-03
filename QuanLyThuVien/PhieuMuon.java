/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Cao Phạm Nhật Quang
 */
public class PhieuMuon implements IPhiPhat {
    private String maPhieuMuon;
    private Date ngayMuon;
    private Date ngayTra;
    private String trangThai;
    
    private ThanhVien thanhVien;
    
    private List<TaiLieu> dsTaiLieu;

    public PhieuMuon(String maPhieuMuon, Date ngayMuon, Date ngayTra, ThanhVien thanhVien) {
        this.maPhieuMuon = maPhieuMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.thanhVien = thanhVien;
        this.trangThai = "Đang mượn";
        this.dsTaiLieu = new ArrayList<>();
    }
    
    public void themTaiLieu(TaiLieu tl) {
        this.dsTaiLieu.add(tl);
    }

    @Override
    public double tinhTienPhat(int soNgayTre) {
        if (soNgayTre <= 0) return 0;
        return soNgayTre * 5000.0;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }
    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }
    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }
    
    public Date getNgayTra() {
        return ngayTra;
    }
    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public ThanhVien getThanhVien() {
        return thanhVien;
    }
    public void setThanhVien(ThanhVien thanhVien) {
        this.thanhVien = thanhVien;
    }

    public List<TaiLieu> getDsTaiLieu() {
        return dsTaiLieu;
    }
    public void setDsTaiLieu(List<TaiLieu> dsTaiLieu) {
        this.dsTaiLieu = dsTaiLieu;
    }
    
    @Override
    public String toString() {
        return "PhieuMuon{" + "ma=" + maPhieuMuon + ", nguoiMuon=" + thanhVien.getHoTen() + '}';
    }
}
