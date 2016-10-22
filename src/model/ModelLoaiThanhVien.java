/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.LoaiThanhVien;
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
public class ModelLoaiThanhVien {
    
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelLoaiThanhVien(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<LoaiThanhVien> getList(){
        ArrayList<LoaiThanhVien> alItem = new ArrayList<>();
        String sql = "SELECT * FROM loaithanhvien";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new LoaiThanhVien(rs.getInt("matv"),rs.getString("tenthanhvien"),rs.getString("mavip")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelLoaiThanhVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelLoaiThanhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return alItem;
    }
    
     public LoaiThanhVien getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        LoaiThanhVien c = null;
        String sql = "SELECT * FROM loaithanhvien WHERE matv = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new LoaiThanhVien(rs.getInt("matv"),rs.getString("tenthanhvien"),rs.getString("mavip"));
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
     
    public int addItem(LoaiThanhVien item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "INSERT INTO loaithanhvien(tenthanhvien,mavip) VALUES (?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1,item.getTenThanhVien());
            pst.setString(2, item.getMaVip());
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
    
    public int editItem(LoaiThanhVien c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE loaithanhvien SET tenthanhvien=?,mavip = ? WHERE matv = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,c.getTenThanhVien());
            pst.setString(2, c.getMaVip());
            pst.setInt(3, c.getMatv());
            pst.executeUpdate();
            result = c.getMatv();
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

        String sql = "DELETE FROM loaithanhvien WHERE matv = ? LIMIT 1";
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
