/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.DichVu;
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
public class ModelDichVu {
    
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelDichVu(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<DichVu> getList(){
        ArrayList<DichVu> alItem = new ArrayList<>();
        String sql = "SELECT * FROM dichvu";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new DichVu(rs.getInt("madv"), rs.getString("tendichvu"), rs.getInt("soluong"), rs.getInt("dongiadichvu")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelDichVu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelDichVu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return alItem;
    }
    
     public DichVu getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        DichVu c = null;
        String sql = "SELECT * FROM dichvu WHERE madv = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new DichVu(rs.getInt("madv"), rs.getString("tendichvu"), rs.getInt("soluong"), rs.getInt("dongiadichvu"));
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
     
    public int addItem(DichVu item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();

        String sql = "INSERT INTO dichvu(tendichvu,soluong,dongiadichvu) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1,item.getTenDichVu());
            pst.setInt(2, item.getSoLuong());
            pst.setInt(3, item.getDonGiaDichVu());
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
    
    public int editItem(DichVu c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE dichvu SET tendichvu = ?,soluong = ?,dongiadichvu = ? WHERE madv = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, c.getTenDichVu());
            pst.setInt(2, c.getSoLuong());
            pst.setInt(3, c.getDonGiaDichVu());
            pst.setInt(4, c.getMaDV());
            pst.executeUpdate();
            result = c.getMaDV();
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

        String sql = "DELETE FROM dichvu WHERE madv = ? LIMIT 1";
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
