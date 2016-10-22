/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.DichVuDung;
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
public class ModelDichVuDung {
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelDichVuDung(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<DichVuDung> getList(){
        ArrayList<DichVuDung> alItem = new ArrayList<>();
        String sql = "SELECT * FROM dichvudung";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new DichVuDung(rs.getInt("madvd"), rs.getInt("makh"), rs.getInt("madv"), rs.getInt("soluong"), rs.getInt("thanhtien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelDichVuDung.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelDichVuDung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return alItem;
    }
    
     public DichVuDung getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        DichVuDung c = null;
        String sql = "SELECT * FROM dichvudung WHERE madvd = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new DichVuDung(rs.getInt("madvd"), rs.getInt("makh"), rs.getInt("madv"), rs.getInt("soluong"), rs.getInt("thanhtien"));
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
     
    public int addItem(DichVuDung item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();

        String sql = "INSERT INTO dichvudung(makh,madv,soluong,thanhtien) VALUES (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1,item.getMaKH());
            pst.setInt(2, item.getMaDV());
            pst.setInt(3, item.getSoLuong());
            pst.setInt(4, item.getThanhTien());
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
    
    public int editItem(DichVuDung c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE dichvudung SET makh = ?,madv = ?,soluong = ?,thanhtien = ? WHERE madvd = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, c.getMaKH());
            pst.setInt(2, c.getMaDV());
            pst.setInt(3, c.getSoLuong());
            pst.setInt(4, c.getThanhTien());
            pst.setInt(5, c.getMaDVD());
            pst.executeUpdate();
            result = c.getMaDVD();
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

        String sql = "DELETE FROM dichvudung WHERE madvd = ? LIMIT 1";
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
