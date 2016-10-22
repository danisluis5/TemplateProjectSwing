/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.KhachHang;
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
public class ModelKhachHang {
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelKhachHang(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<KhachHang> getList(){
        ArrayList<KhachHang> alItem = new ArrayList<>();
        String sql = "SELECT * FROM khachhang";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new KhachHang(rs.getInt("makh"), rs.getString("tenkhachhang"),rs.getString("gioitinh"),rs.getTimestamp("ngaysinh"), rs.getString("socmt"),rs.getString("email"),rs.getString("diachi"),rs.getString("nghenghiep"),rs.getString("sodienthoai"),rs.getString("quoctich"),rs.getInt("matv")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelTang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelTang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return alItem;
    }
    
     public KhachHang getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        KhachHang c = null;
        String sql = "SELECT * FROM khachhang WHERE makh = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new KhachHang(rs.getInt("makh"),rs.getString("tenkhachhang"), rs.getString("gioitinh"),rs.getTimestamp("ngaysinh"), rs.getString("socmt"),rs.getString("email"),rs.getString("diachi"),rs.getString("nghenghiep"),rs.getString("sodienthoai"),rs.getString("quoctich"),rs.getInt("matv"));
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
     
    public int addItem(KhachHang item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();

        String sql = "INSERT INTO khachhang(tenkhachhang,gioitinh,ngaysinh,socmt,email,diachi,nghenghiep,sodienthoai,quoctich,matv) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, item.getTenKhachHang());
            pst.setString(2, item.getGioiTinh());
            pst.setTimestamp(3, item.getNgaySinh());
            pst.setString(4, item.getSoCMT());
            pst.setString(5, item.getThuDienTu());
            pst.setString(6, item.getDiaChi());
            pst.setString(7, item.getNgheNghiep());
            pst.setString(8, item.getSoDienThoai());
            pst.setString(9, item.getQuocTich());
            pst.setInt(10, item.getMaTV());
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
    
    public int editItem(KhachHang c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE khachhang SET tenkhachhang = ?,gioitinh = ?,ngaysinh = ?,socmt = ?,email = ?,diachi = ?,nghenghiep = ?,sodienthoai = ?,quoctich = ?,matv = ? WHERE makh = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, c.getTenKhachHang());
            pst.setString(2, c.getGioiTinh());
            pst.setTimestamp(3, c.getNgaySinh());
            pst.setString(4, c.getSoCMT());
            pst.setString(5, c.getThuDienTu());
            pst.setString(6, c.getDiaChi());
            pst.setString(7, c.getNgheNghiep());
            pst.setString(8, c.getSoDienThoai());
            pst.setString(9, c.getQuocTich());
            pst.setInt(10, c.getMaTV());
            pst.setInt(11, c.getMaKH());
            pst.executeUpdate();
            result = c.getMaKH();
        } catch (SQLException e) {
        } finally {
            try {
//                pst.close();
                conn.close();
            } catch (SQLException e) {
            }
        }
        return result;
    }
    
    public int delItem(int cid) {
        int result = 0;
        conn = lcdb.getConnectMySQL();

        String sql = "DELETE FROM khachhang WHERE makh = ? LIMIT 1";
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
