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
public class KhachHang {
    private int maKH;
    private String tenKhachHang;
    private String gioiTinh;
    private Timestamp ngaySinh;
    private String soCMT;
    private String thuDienTu;
    private String diaChi;
    private String ngheNghiep;
    private String soDienThoai;
    private String quocTich;
    private int maTV;

    public KhachHang() {
    }

    public KhachHang(int maKH, String tenKhachHang, String gioiTinh, Timestamp ngaySinh, String soCMT, String thuDienTu, String diaChi, String ngheNghiep, String soDienThoai, String quocTich, int maTV) {
        this.maKH = maKH;
        this.tenKhachHang = tenKhachHang;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soCMT = soCMT;
        this.thuDienTu = thuDienTu;
        this.diaChi = diaChi;
        this.ngheNghiep = ngheNghiep;
        this.soDienThoai = soDienThoai;
        this.quocTich = quocTich;
        this.maTV = maTV;
    }

    public Timestamp getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    
    public int getMaKH() {
        return maKH;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String isSoCMT() {
        return soCMT;
    }

    public String getThuDienTu() {
        return thuDienTu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setSoCMT(String soCMT) {
        this.soCMT = soCMT;
    }

    public void setThuDienTu(String thuDienTu) {
        this.thuDienTu = thuDienTu;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSoCMT() {
        return soCMT;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
}
