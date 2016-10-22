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
public class LoaiThanhVien {
    
    private int matv;
    private String tenThanhVien;
    private String maVip;

    public LoaiThanhVien() {
    }

    public LoaiThanhVien(int matv, String tenThanhVien, String maVip) {
        this.matv = matv;
        this.tenThanhVien = tenThanhVien;
        this.maVip = maVip;
    }

    public int getMatv() {
        return matv;
    }

    public String getTenThanhVien() {
        return tenThanhVien;
    }

    public String getMaVip() {
        return maVip;
    }

    public void setMatv(int matv) {
        this.matv = matv;
    }

    public void setTenThanhVien(String tenThanhVien) {
        this.tenThanhVien = tenThanhVien;
    }

    public void setMaVip(String maVip) {
        this.maVip = maVip;
    }
    
    @Override
    public String toString(){
        return this.getTenThanhVien();
    }
}
