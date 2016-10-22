/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author vuongluis
 */
public class DichVuDung {
    private int maDVD;
    private int maKH;
    private int maDV;
    private int soLuong;
    private int thanhTien;

    public DichVuDung() {
    }

    public DichVuDung(int maDVD, int maKH, int maDV, int soLuong, int thanhTien) {
        this.maDVD = maDVD;
        this.maKH = maKH;
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public int getMaDVD() {
        return maDVD;
    }

    public int getMaKH() {
        return maKH;
    }

    public int getMaDV() {
        return maDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setMaDVD(int maDVD) {
        this.maDVD = maDVD;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}
