/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;
import java.io.File;
import java.io.PrintWriter; // Để ghi file dễ như in màn hình
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Cao Phạm Nhật Quang
 */
public class QuanLyThuVien implements IReadWrite {
    private HashMap<String, TaiLieu> dsTaiLieu;
    private HashMap<String, Person> dsPerson;
    private HashMap<String, PhieuMuon> dsPhieuMuon;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public QuanLyThuVien() {
        this.dsTaiLieu = new HashMap<>();
        this.dsPerson = new HashMap<>();
        this.dsPhieuMuon = new HashMap<>();
    }

    public void themTaiLieu(TaiLieu tl) { 
        if (tl!=null) 
            dsTaiLieu.put(tl.getMaTaiLieu(), tl); 
    }
    public TaiLieu timTaiLieu(String ma) { 
        return dsTaiLieu.get(ma); 
    }
    public boolean xoaTaiLieu(String ma) {
        if (dsTaiLieu.containsKey(ma)) {
            dsTaiLieu.remove(ma);
            return true;
        }
        return false;
    }
    
    public void themPerson(Person p) { 
        if (p instanceof ThanhVien) 
            dsPerson.put(((ThanhVien)p).getMaThanhVien(), p);
        else if (p instanceof NhanVien) 
            dsPerson.put(((NhanVien)p).getMaNhanVien(), p);
    }
    public Person timPerson(String ma) { 
        return dsPerson.get(ma); 
    }
    public boolean xoaPerson(String ma) {
        if (dsPerson.containsKey(ma)) {
            dsPerson.remove(ma);
            return true;
        }
        return false;
    }
    
    public void themPhieuMuon(PhieuMuon pm) { 
        dsPhieuMuon.put(pm.getMaPhieuMuon(), pm); 
    }
    public PhieuMuon timPhieuMuon(String ma) { 
        return dsPhieuMuon.get(ma); 
    }
    
    public boolean xoaPhieuMuon(String ma) {
        if (dsPhieuMuon.containsKey(ma)) { 
            dsPhieuMuon.remove(ma); return true; 
        }
        return false;
    }
    public HashMap<String, PhieuMuon> getDsPhieuMuon() {
    return this.dsPhieuMuon;
    }
    
    public HashMap<String, TaiLieu> getDsTaiLieu() {
        return this.dsTaiLieu;
    }

    public HashMap<String, Person> getDsPerson() {
        return this.dsPerson;
    }

    @Override
    public void ghiDuLieu() {
        try {
            PrintWriter pw = new PrintWriter(IReadWrite.FILE_NAME);
            for (PhieuMuon pm : dsPhieuMuon.values()) {

                String ngayMuon = sdf.format(pm.getNgayMuon());
                String ngayTra = sdf.format(pm.getNgayTra());
                String maTV = "null";
                if (pm.getThanhVien() != null) {
                    maTV = pm.getThanhVien().getMaThanhVien();
                }

                pw.print(pm.getMaPhieuMuon() + "," + ngayMuon + "," + ngayTra + "," + maTV);

                for (TaiLieu tl : pm.getDsTaiLieu()) {
                    pw.print("," + tl.getMaTaiLieu());
                }

                pw.println(); 
            }

            pw.close();
            System.out.println("Ghi file thanh cong!");

        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    @Override
    public void docDuLieu() {
        try {
            File file = new File(IReadWrite.FILE_NAME);
            if (!file.exists()) return;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                
                String line = sc.nextLine();
                
                if (line.trim().isEmpty()) continue; 

                String[] data = line.split(",");
                
                if (data.length >= 4) {
                    String maPM = data[0];
                    Date nm = sdf.parse(data[1]);
                    Date nt = sdf.parse(data[2]);
                    String maTV = data[3];

                    ThanhVien tv = new ThanhVien(maTV, "Unknown", "", "");
                    PhieuMuon pm = new PhieuMuon(maPM, nm, nt, tv);

                    for (int i = 4; i < data.length; i++) {
                        String maSach = data[i];
                        Sach s = new Sach(maSach, "", 0, "", 0, "");
                        pm.themTaiLieu(s);
                    }
                    
                    dsPhieuMuon.put(maPM, pm);
                }
            }
            
            sc.close();
            System.out.println("Doc file xong. So luong: " + dsPhieuMuon.size());

        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
        
    }
}
