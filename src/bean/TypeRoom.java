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
public class TypeRoom {
    
    private int maLP;
    private String tenPhong;
    private int donGia;
    private String moTa;

    public TypeRoom() {
    }

    public TypeRoom(int maLP, String tenPhong, int donGia,String moTa) {
        this.maLP = maLP;
        this.tenPhong = tenPhong;
        this.donGia = donGia;
        this.moTa = moTa;
    }    

    public int getMaLP() {
        return maLP;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setMaLP(int maLP) {
        this.maLP = maLP;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }
    public String toString(){
        return this.getTenPhong();
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
