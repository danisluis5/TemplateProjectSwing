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
public class HoaDon {
    private int maHD;
    private String tenHoaDon;
    private int maKH;
    private int maNV;
    private Timestamp ngayLapHoaDon;

    public HoaDon() {
    }

    public HoaDon(int maHD, String tenHoaDon, int maKH, int maNV, Timestamp ngayLapHoaDon) {
        this.maHD = maHD;
        this.tenHoaDon = tenHoaDon;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public int getMaHD() {
        return maHD;
    }

    public String getTenHoaDon() {
        return tenHoaDon;
    }

    public int getMaKH() {
        return maKH;
    }

    public int getMaNV() {
        return maNV;
    }

    public Timestamp getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setTenHoaDon(String tenHoaDon) {
        this.tenHoaDon = tenHoaDon;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setNgayLapHoaDon(Timestamp ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }
}
