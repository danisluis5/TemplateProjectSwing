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
public class Floor {
    private int maT;
    private int tang;
    private int soPhong;

    public Floor() {
    }

    public Floor(int maT,int tang, int soPhong) {
        this.maT = maT;
        this.tang = tang;
        this.soPhong = soPhong;
    }

    public int getMaT(){
        return maT;
    }
    
    public int getTang() {
        return tang;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setMaT(int maT){
        this.maT = maT;
    }
    
    public void setTang(int tang) {
        this.tang = tang;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }
    @Override
    public String toString(){
        return String.valueOf(this.getTang());
    }
}
