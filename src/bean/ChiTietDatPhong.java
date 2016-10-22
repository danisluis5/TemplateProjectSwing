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
public class ChiTietDatPhong {
    private int maCTDP;
    private int maKH;
    private int maP;
    private Timestamp thoiGianDatPhong;
    private Timestamp thoiGianTraPhong; 

    public ChiTietDatPhong() {
    }

    public ChiTietDatPhong(int maCTDP, int maKH, int maP, Timestamp thoiGianDatPhong, Timestamp thoiGianTraPhong) {
        this.maCTDP = maCTDP;
        this.maKH = maKH;
        this.maP = maP;
        this.thoiGianDatPhong = thoiGianDatPhong;
        this.thoiGianTraPhong = thoiGianTraPhong;
    }

    public int getMaCTDP() {
        return maCTDP;
    }

    public int getMaKH() {
        return maKH;
    }

    public int getMaP() {
        return maP;
    }

    public Timestamp getThoiGianDatPhong() {
        return thoiGianDatPhong;
    }

    public Timestamp getThoiGianTraPhong() {
        return thoiGianTraPhong;
    }

    public void setMaCTDP(int maCTDP) {
        this.maCTDP = maCTDP;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setMaP(int maP) {
        this.maP = maP;
    }

    public void setThoiGianDatPhong(Timestamp thoiGianDatPhong) {
        this.thoiGianDatPhong = thoiGianDatPhong;
    }

    public void setThoiGianTraPhong(Timestamp thoiGianTraPhong) {
        this.thoiGianTraPhong = thoiGianTraPhong;
    }
}
