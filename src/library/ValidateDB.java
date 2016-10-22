/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vuongluis
 */
public class ValidateDB {
    public boolean sophong_exist(int soPhong){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKA FROM phong WHERE sophong = ?");
            pst.setInt(1, soPhong);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count > 0){
            isExist = true;
        }
        return isExist;
    }
    public boolean sophong_existver(int soPhong,int id){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKB FROM phong WHERE sophong = ? AND map NOT IN(?)");
            pst.setInt(1, soPhong);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKB");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count > 0){
            isExist = true;
        }
        return isExist;
    }
    public boolean typeroom_exist(String tenphong){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKA FROM loaiphong WHERE tenphong = ?");
            pst.setString(1, tenphong);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        isExist = ((count > 0)?true:false);
        return isExist;
    }
    public boolean typeroom_existver(String tenPhong,int id){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKB FROM loaiphong WHERE tenphong = ? AND malp NOT IN(?)");
            pst.setString(1, tenPhong);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKB");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count > 0){
            isExist = true;
        }
        return isExist;
    }
    
    public boolean floor_exist(int tang){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKA FROM tang WHERE tang = ?");
            pst.setInt(1, tang);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        isExist = ((count > 0)?true:false);
        return isExist;
    }
    public boolean floor_existver(int tang,int id){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKB FROM tang WHERE tang = ? AND mat NOT IN(?)");
            pst.setInt(1, tang);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKB");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count > 0){
            isExist = true;
        }
        return isExist;
    }
    
    public boolean socmt_exist(String socmt){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKA FROM khachhang WHERE socmt = ?");
            pst.setString(1, socmt);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        isExist = ((count > 0)?true:false);
        return isExist;
    }
    
    public boolean socmt_existver(String socmt,int id){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKB FROM khachhang WHERE socmt = ? AND makh NOT IN(?)");
            pst.setString(1, socmt);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKB");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count > 0){
            isExist = true;
        }
        return isExist;
    }
    
    public boolean tenthanhvien_exist(String tenThanhVien){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKA FROM loaithanhvien WHERE tenthanhvien = ?");
            pst.setString(1, tenThanhVien);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        isExist = ((count > 0)?true:false);
        return isExist;
    }
    
    public boolean tenthanhvien_existver(String tenThanhVien,int id){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKB FROM loaithanhvien WHERE tenthanhvien = ? AND matv NOT IN(?)");
            pst.setString(1, tenThanhVien);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKB");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count > 0){
            isExist = true;
        }
        return isExist;
    }
    
    public boolean dichvu_exist(String tenDichVu){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKA FROM dichvu WHERE tendichvu = ?");
            pst.setString(1, tenDichVu);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKA");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        isExist = ((count > 0)?true:false);
        return isExist;
    }
    
    public boolean dichvu_existver(String tenDichVu,int id){
        boolean isExist = false;
        int count = 0;
        Connection conn = new LibraryConnectDb().getConnectMySQL();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT COUNT(*) AS CHECKB FROM dichvu WHERE tendichvu = ? AND madv NOT IN(?)");
            pst.setString(1, tenDichVu);
            pst.setInt(2, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                count = rs.getInt("CHECKB");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ValidateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(count > 0){
            isExist = true;
        }
        return isExist;
    }
}
