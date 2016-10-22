/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.NhanVien;
import bean.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.LibraryConnectDb;

/**
 *
 * @author vuongluis
 */
public class ModelNhanVien {
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelNhanVien(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<NhanVien> getList(){
        ArrayList<NhanVien> alItem = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new NhanVien(rs.getInt("manv"), rs.getString("hoten"), rs.getTimestamp("ngaysinh"), rs.getString("gioitinh"), rs.getInt("socmt"), rs.getString("diachi"), rs.getInt("sodienthoai"), rs.getString("chucvu")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return alItem;
    }
    
     public NhanVien getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        NhanVien c = null;
        String sql = "SELECT * FROM nhanvien WHERE manv = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new NhanVien(rs.getInt("manv"), rs.getString("hoten"), rs.getTimestamp("ngaysinh"), rs.getString("gioitinh"), rs.getInt("socmt"), rs.getString("diachi"), rs.getInt("sodienthoai"), rs.getString("chucvu"));
            }
        } catch (SQLException e) {
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return c;
    }
     
    public int addItem(NhanVien item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "INSERT INTO nhanvien(hoten,ngaysinh,gioitinh,socmt,diachi,sodienthoai,chucvu) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, item.getHoTen());
            pst.setTimestamp(2, item.getNgaySinh());
            pst.setString(3, item.isGioiTinh());
            pst.setInt(4, item.getSoCMT());
            pst.setString(5, item.getDiaChi());
            pst.setInt(6, item.getSoDienThoai());
            pst.setString(7, item.getChucVu());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next()){
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return result;
    }
    
    public int editItem(NhanVien c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE nhanvien SET hoten=?,ngaysinh = ?,gioitinh = ?,socmt = ?,diachi = ?,sodienthoai = ?,chucvu = ? WHERE manv=? LIMIT 1";
        try {
            pst.setString(1, c.getHoTen());
            pst.setTimestamp(2, c.getNgaySinh());
            pst.setString(3, c.isGioiTinh());
            pst.setInt(4, c.getSoCMT());
            pst.setString(5, c.getDiaChi());
            pst.setInt(6, c.getSoDienThoai());
            pst.setString(7, c.getChucVu());
            pst.setInt(8, c.getMaNV());
            pst.executeUpdate();
            result = c.getMaNV();
        } catch (SQLException e) {
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return result;
    }
    
    public int delItem(int cid) {
        int result = 0;
        conn = lcdb.getConnectMySQL();

        String sql = "DELETE FROM nhanvien WHERE manv = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            pst.executeUpdate();
            result = 1;
        } catch (SQLException e) {
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return result;
    }
}
