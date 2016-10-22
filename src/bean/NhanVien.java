/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;

/**
 *
 * @author vuongluis
 */
public class NhanVien {
    private int maNV;
    private String hoTen;
    private Timestamp ngaySinh;
    private String gioiTinh;
    private int soCMT;
    private String diaChi;
    private int soDienThoai;
    private String chucVu;

    public NhanVien() {
    }

    public NhanVien(int maNV, String hoTen, Timestamp ngaySinh, String gioiTinh, int soCMT, String diaChi, int soDienThoai, String chucVu) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMT = soCMT;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.chucVu = chucVu;
    }

    public int getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public Timestamp getNgaySinh() {
        return ngaySinh;
    }

    public String isGioiTinh() {
        return gioiTinh;
    }

    public int getSoCMT() {
        return soCMT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSoCMT(int soCMT) {
        this.soCMT = soCMT;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
