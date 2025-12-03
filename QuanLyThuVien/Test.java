/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.baitapcanhan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Cao Phạm Nhật Quang
 */
public class Test {
    static Scanner sc = new Scanner(System.in);
    static QuanLyThuVien ql = new QuanLyThuVien();
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        
        taoDuLieuMau();

        int chon = 0;
        do {
            System.out.println("\n====== HE THONG QUAN LY THU VIEN (FULL) ======");
            System.out.println("1. Quan ly TAI LIEU (Them Sach/Bao/Tap chi)");
            System.out.println("2. Quan ly NGUOI (Them Thanh vien/Nhan vien)");
            System.out.println("3. Quan ly PHIEU MUON (Muon/Tra/Phat)");
            System.out.println("----------------------------------------------");
            System.out.println("4. Hien thi TOAN BO du lieu");
            System.out.println("5. LUU du lieu (Ghi File)");
            System.out.println("6. NAP du lieu (Doc File)");
            System.out.println("7. Tim kiem & Xoa");
            System.out.println("0. Thoat");
            System.out.print(">> Chon chuc nang: ");
            
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) { chon = -1; }

            switch (chon) {
                case 1: menuThemTaiLieu(); break;
                case 2: menuThemNguoi();   break;
                case 3: chucNangTaoPhieu(); break;
                case 4: chucNangHienThiFull(); break;
                case 5: ql.ghiDuLieu(); break;
                case 6: ql.docDuLieu(); break;
                case 7: menuTimKiemXoa(); break;
                case 0: System.out.println("Ket thuc!"); break;
                default: System.out.println("Sai chuc nang!");
            }
        } while (chon != 0);
    }

    private static void menuThemTaiLieu() {
        System.out.println("\n--- THEM TAI LIEU ---");
        System.out.println("1. Them SACH");
        System.out.println("2. Them BAO");
        System.out.println("3. Them TAP CHI");
        System.out.print("Chon loai: ");
        int loai = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap Ma: "); String ma = sc.nextLine();
        System.out.print("Nhap NXB: "); String nxb = sc.nextLine();
        System.out.print("Nhap So luong: "); int sl = Integer.parseInt(sc.nextLine());

        TaiLieu tl = null;

        if (loai == 1) {
            System.out.print("Ten Tac Gia: "); String tg = sc.nextLine();
            System.out.print("So Trang: "); int str = Integer.parseInt(sc.nextLine());
            System.out.print("The Loai: "); String theloai = sc.nextLine();
            tl = new Sach(ma, nxb, sl, tg, str, theloai);
        } 
        else if (loai == 2) {
            System.out.print("Ngay Phat Hanh (dd/MM/yyyy): "); 
            Date ngayPH = new Date();
            try { ngayPH = sdf.parse(sc.nextLine()); } catch (Exception e) {}
            tl = new Bao(ma, nxb, sl, ngayPH);
        }
        else if (loai == 3) {
            System.out.print("So Phat Hanh: "); int sph = Integer.parseInt(sc.nextLine());
            System.out.print("Thang Phat Hanh: "); int tph = Integer.parseInt(sc.nextLine());
            tl = new TapChi(ma, nxb, sl, sph, tph);
        }

        if (tl != null) {
            ql.themTaiLieu(tl);
            System.out.println(">> Them thanh cong!");
        }
    }

    private static void menuThemNguoi() {
        System.out.println("\n--- THEM NGUOI ---");
        System.out.println("1. Them THANH VIEN");
        System.out.println("2. Them NHAN VIEN");
        System.out.print("Chon loai: ");
        int loai = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap Ho Ten: "); String ten = sc.nextLine();
        System.out.print("Nhap SDT: "); String sdt = sc.nextLine();
        System.out.print("Nhap Email: "); String email = sc.nextLine();
        System.out.print("Nhap MA So: "); String ma = sc.nextLine();

        Person p = null;

        if (loai == 1) {
            p = new ThanhVien(ma, ten, sdt, email);
        } else if (loai == 2) {
            System.out.print("Nhap Chuc Vu: "); String cv = sc.nextLine();
            p = new NhanVien(ma, ten, sdt, email, cv);
        }

        if (p != null) {
            ql.themPerson(p);
            System.out.println(">> Them nguoi thanh cong!");
        }
    }

    private static void chucNangTaoPhieu() {
        System.out.println("\n--- TAO PHIEU MUON MOI ---");
        
        System.out.print("Nhap Ma Phieu Muon: "); 
        String maPM = sc.nextLine();
        
        System.out.println("\n>> Danh sach Nguoi dung trong he thong:");
        if (ql.getDsPerson().isEmpty()) {
            System.out.println("   (Chua co nguoi dung nao! Vui long them nguoi truoc.)");
            return;
        }
        for (Person p : ql.getDsPerson().values()) {

            if (p instanceof ThanhVien) {
                System.out.println("   - [" + ((ThanhVien)p).getMaThanhVien() + "] " + p.getHoTen());
            }
        }

        System.out.print("Nhap Ma Thanh Vien muon: "); 
        String maTV = sc.nextLine();
        
        Person p = ql.timPerson(maTV);
        if (p == null || !(p instanceof ThanhVien)) {
            System.out.println("(!) LOI: Khong tim thay thanh vien nay!");
            return;
        }
        System.out.println("-> Da chon: " + p.getHoTen());

        PhieuMuon pm = new PhieuMuon(maPM, new Date(), new Date(), (ThanhVien)p);

        while (true) {
            System.out.println("\n>> Danh sach Tai Lieu trong kho:");
            if (ql.getDsTaiLieu().isEmpty()) {
                System.out.println("   (Kho rong!)");
                break;
            }
            
            for (TaiLieu tl : ql.getDsTaiLieu().values()) {
                String loai = (tl instanceof Sach) ? "Sach" : (tl instanceof Bao) ? "Bao" : "TapChi";
                System.out.println("   - [" + tl.getMaTaiLieu() + "] " + loai + ": " + tl.getNhaXuatBan());
            }

            System.out.print("Nhap Ma Tai Lieu muon them (Go 'exit' de dung): "); 
            String maTL = sc.nextLine();
            
            if (maTL.equalsIgnoreCase("exit")) break;

            TaiLieu tl = ql.timTaiLieu(maTL);
            
            if (tl != null) {
                pm.themTaiLieu(tl);
                System.out.println("-> OK! Da them '" + tl.getNhaXuatBan() + "' vao phieu.");
            } else {
                System.out.println("(!) LOI: Ma tai lieu khong ton tai!");
            }
        }

        ql.themPhieuMuon(pm);
        System.out.println("\n>> TAO PHIEU THANH CONG!");
        System.out.println("   Ma phieu: " + pm.getMaPhieuMuon());
        System.out.println("   Nguoi muon: " + pm.getThanhVien().getHoTen());
        System.out.println("   Tong so tai lieu: " + pm.getDsTaiLieu().size());
    }

    private static void chucNangHienThiFull() {
        System.out.println("\n--- DANH SACH TAI LIEU ---");
        for (TaiLieu tl : ql.getDsTaiLieu().values()) {
            String loai = (tl instanceof Sach) ? "Sach" : (tl instanceof Bao) ? "Bao" : "TapChi";
            System.out.println("[" + loai + "] " + tl.getMaTaiLieu() + " - NXB: " + tl.getNhaXuatBan());
        }

        System.out.println("\n--- DANH SACH NGUOI ---");
        for (Person p : ql.getDsPerson().values()) {
            System.out.println(p.toString());
        }

        System.out.println("\n--- DANH SACH PHIEU ---");
        for (PhieuMuon pm : ql.getDsPhieuMuon().values()) {
            System.out.println(pm.toString());
        }
    }

    private static void menuTimKiemXoa() {
        System.out.println("1. Xoa Tai Lieu / 2. Xoa Nguoi / 3. Xoa Phieu");
        System.out.println("4. Tim Tai Lieu / 5. Tim Nguoi / 6. Tim Phieu");
        System.out.print("Chon: ");
        int c = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap MA: "); String ma = sc.nextLine();
        
        if (c==1) System.out.println(ql.xoaTaiLieu(ma) ? "Xoa OK" : "Loi");
        if (c==2) System.out.println(ql.xoaPerson(ma) ? "Xoa OK" : "Loi");
        if (c==3) System.out.println(ql.xoaPhieuMuon(ma) ? "Xoa OK" : "Loi");
        
        if (c==4) {
            TaiLieu tl = ql.timTaiLieu(ma);
            System.out.println(tl != null ? "Tim thay: " + tl.getNhaXuatBan() : "Khong thay");
        }
        if (c==5) {
            Person p = ql.timPerson(ma);
            System.out.println(p != null ? "Tim thay: " + p.getHoTen() : "Khong thay");
        }
        if (c==6) {
            PhieuMuon pm = ql.timPhieuMuon(ma);
            System.out.println(pm != null ? "Tim thay: " + pm.getMaPhieuMuon() : "Khong thay");
        }
    }

    private static void taoDuLieuMau() {
        ql.themTaiLieu(new Sach("S01", "Kim Dong", 100, "Tac Gia A", 120, "Truyen"));
        ql.themTaiLieu(new Bao("B01", "Thanh Nien", 5000, new Date()));
        ql.themPerson(new ThanhVien("TV01", "Nguyen Van A", "0909", "a@mail"));
        ql.themPerson(new NhanVien("NV01", "Co Thu Thu", "0908", "b@mail", "Quan Ly"));
    }
}