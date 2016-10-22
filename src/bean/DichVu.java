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
public class DichVu {
    private int maDV;
    private String tenDichVu;
    private int soLuong;
    private int donGiaDichVu;

    public DichVu() {
    }

    public DichVu(int maDV, String tenDichVu, int soLuong, int donGiaDichVu) {
        this.maDV = maDV;
        this.tenDichVu = tenDichVu;
        this.soLuong = soLuong;
        this.donGiaDichVu = donGiaDichVu;
    }

    public int getMaDV() {
        return maDV;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getDonGiaDichVu() {
        return donGiaDichVu;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGiaDichVu(int donGiaDichVu) {
        this.donGiaDichVu = donGiaDichVu;
    }
}
