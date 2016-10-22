/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.ChiTietDatPhong;
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
public class ModelChiTietDatPhong {
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelChiTietDatPhong(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<ChiTietDatPhong> getList(){
        ArrayList<ChiTietDatPhong> alItem = new ArrayList<>();
        String sql = "SELECT * FROM chitietdatphong";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new ChiTietDatPhong(rs.getInt("mactdp"), rs.getInt("makh"), rs.getInt("map"), rs.getTimestamp("thoigiandatphong"), rs.getTimestamp("thoigiantraphong")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelChiTietDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelChiTietDatPhong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return alItem;
    }
    
     public ChiTietDatPhong getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        ChiTietDatPhong c = null;
        String sql = "SELECT * FROM chitietdatphong WHERE mactdp = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new ChiTietDatPhong(rs.getInt("mactdp"), rs.getInt("makh"), rs.getInt("map"), rs.getTimestamp("thoigiandatphong"), rs.getTimestamp("thoigiantraphong"));
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
     
    public int addItem(ChiTietDatPhong item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();

        String sql = "INSERT INTO chitietdatphong(makh,map,thoigiandatphong,thoigiantraphong) VALUES (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1,item.getMaKH());
            pst.setInt(2, item.getMaP());
            pst.setTimestamp(3, item.getThoiGianDatPhong());
            pst.setTimestamp(4, item.getThoiGianTraPhong());
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
    
    public int editItem(ChiTietDatPhong c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE chitietdatphong SET makh=?,map = ?,thoigiandatphong = ?,thoigiantraphong = ? WHERE mactdp = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, c.getMaKH());
            pst.setInt(2, c.getMaP());
            pst.setTimestamp(3, c.getThoiGianDatPhong());
            pst.setTimestamp(4, c.getThoiGianTraPhong());
            pst.setInt(5,c.getMaCTDP());
            pst.executeUpdate();
            result = c.getMaCTDP();
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

        String sql = "DELETE FROM chitietdatphong WHERE mactdp = ? LIMIT 1";
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
