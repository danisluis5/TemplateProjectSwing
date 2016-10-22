/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.TypeRoom;
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
public class ModelLoaiPhong {
    
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelLoaiPhong(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<TypeRoom> getList(){
        ArrayList<TypeRoom> alItem = new ArrayList<>();
        String sql = "SELECT * FROM loaiphong";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new TypeRoom(rs.getInt("malp"),rs.getString("tenphong"), rs.getInt("dongia"),rs.getString("mota")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelLoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelLoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return alItem;
    }
    
     public TypeRoom getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        TypeRoom c = null;
        String sql = "SELECT * FROM loaiphong WHERE malp = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new TypeRoom(rs.getInt("malp"),rs.getString("tenphong"), rs.getInt("dongia"),rs.getString("mota"));
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
     
    public TypeRoom getItemName(String loaiPhong) {
        conn = lcdb.getConnectMySQL();
        TypeRoom c = null;
        String sql = "SELECT * FROM loaiphong WHERE tenphong = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, loaiPhong);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new TypeRoom(rs.getInt("malp"),rs.getString("tenphong"), rs.getInt("dongia"),rs.getString("mota"));
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
     
    public int addItem(TypeRoom item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();

        String sql = "INSERT INTO loaiphong(tenphong,dongia,mota) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, item.getTenPhong());
            pst.setInt(2, item.getDonGia());
            pst.setString(3, item.getMoTa());
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
    
    public int editItem(TypeRoom c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE loaiphong SET tenphong=?,dongia = ?,mota = ? WHERE malp=? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, c.getTenPhong());
            pst.setInt(2, c.getDonGia());
            pst.setString(3, c.getMoTa());
            pst.setInt(4, c.getMaLP());
            result = pst.executeUpdate();
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

        String sql = "DELETE FROM loaiphong WHERE malp = ? LIMIT 1";
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
