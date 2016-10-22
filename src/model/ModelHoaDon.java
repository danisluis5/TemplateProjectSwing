/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.DichVu;
import bean.HoaDon;
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
public class ModelHoaDon {
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelHoaDon(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<HoaDon> getList(){
        ArrayList<HoaDon> alItem = new ArrayList<>();
        String sql = "SELECT * FROM hoadon";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new HoaDon(rs.getInt("mahd"), rs.getString("tenhoadon"), rs.getInt("makh"), rs.getInt("manv"), rs.getTimestamp("ngaylaphoadon")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alItem;
    }
    
     public HoaDon getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        HoaDon c = null;
        String sql = "SELECT * FROM hoadon WHERE mahd = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new HoaDon(rs.getInt("mahd"), rs.getString("tenhoadon"), rs.getInt("makh"), rs.getInt("manv"), rs.getTimestamp("ngaylaphoadon"));
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
     
    public int addItem(HoaDon item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();

        String sql = "INSERT INTO hoadon(tenhoadon,makh,manv,ngaylaphoadon) VALUES (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1,item.getTenHoaDon());
            pst.setInt(2, item.getMaKH());
            pst.setInt(3, item.getMaNV());
            pst.setTimestamp(4, item.getNgayLapHoaDon());
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
    
    public int editItem(HoaDon c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE hoadon SET tenhoadon = ?,makh = ?,manv = ?,ngaylaphoadon = ? WHERE mahd = ? LIMIT 1";
        try {
            pst.setString(1, c.getTenHoaDon());
            pst.setInt(2, c.getMaKH());
            pst.setInt(3, c.getMaNV());
            pst.setTimestamp(4, c.getNgayLapHoaDon());
            pst.setInt(5, c.getMaHD());
            pst.executeUpdate();
            result = c.getMaHD();
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

        String sql = "DELETE FROM hoadon WHERE mahd = ? LIMIT 1";
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
