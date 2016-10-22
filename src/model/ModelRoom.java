/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class ModelRoom {
    
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelRoom(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<Room> getList(){
        ArrayList<Room> alItem = new ArrayList<>();
        String sql = "SELECT * FROM phong";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new Room(rs.getInt("map"), rs.getInt("sophong"), rs.getString("tinhtrang"),rs.getString("trangthai"), rs.getString("ghichu"), rs.getInt("malp"), rs.getInt("tang")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return alItem;
    }
    
     public Room getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        Room c = null;
        String sql = "SELECT * FROM phong WHERE map = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new Room(rs.getInt("map"), rs.getInt("sophong"), rs.getString("tinhtrang"), rs.getString("trangthai"), rs.getString("ghichu"), rs.getInt("malp"), rs.getInt("tang"));
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
     
    public int addItem(Room item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "INSERT INTO phong(sophong,tinhtrang,trangthai,ghichu,malp,tang) VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1,item.getSoPhong());
            pst.setString(2, item.getTinhtrang());
            pst.setString(3, item.getTrangThai());
            pst.setString(4, item.getGhiChu());
            pst.setInt(5, item.getMaLP());
            pst.setInt(6,item.getTang());
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
    
    public int editItem(Room c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE phong SET sophong=?,tinhtrang = ?,trangthai = ?,ghichu = ?,malp = ?,tang = ? WHERE map=? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, c.getSoPhong());
            pst.setString(2, c.getTinhtrang());
            pst.setString(3, c.getTrangThai());
            pst.setString(4, c.getGhiChu());
            pst.setInt(5, c.getMaLP());
            pst.setInt(6, c.getMaTang());
            pst.setInt(7, c.getMaP());
            pst.executeUpdate();
            result = c.getMaP();
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

        String sql = "DELETE FROM phong WHERE map = ? LIMIT 1";
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
