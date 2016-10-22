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
public class Room {
    private int maP;
    private int soPhong;
    private String tinhtrang;
    private String trangThai;
    private String ghiChu;
    private int maLP;
    private int tang;

    public Room() {
    }

    public Room(int maP, int soPhong, String tinhtrang, String trangThai, String ghiChu, int maLP, int tang) {
        this.maP = maP;
        this.soPhong = soPhong;
        this.tinhtrang = tinhtrang;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.maLP = maLP;
        this.tang = tang;
    }

    public int getMaP() {
        return maP;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public int getMaLP() {
        return maLP;
    }

    public int getMaTang() {
        return tang;
    }

    public void setMaP(int maP) {
        this.maP = maP;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setMaLP(int maLP) {
        this.maLP = maLP;
    }

    public void setMaTang(int tang) {
        this.tang = tang;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public int getTang() {
        return tang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }
}
