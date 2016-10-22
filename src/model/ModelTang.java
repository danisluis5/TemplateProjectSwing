/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Floor;
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
public class ModelTang {
    
    private LibraryConnectDb lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;
    
    public ModelTang(){
        lcdb = new LibraryConnectDb();
    }
    
    public ArrayList<Floor> getList(){
        ArrayList<Floor> alItem = new ArrayList<>();
        String sql = "SELECT * FROM tang";

        conn = lcdb.getConnectMySQL();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                alItem.add(new Floor(rs.getInt("mat"),rs.getInt("tang"), rs.getInt("sophong")));
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
    
     public Floor getItem(int cid) {
        conn = lcdb.getConnectMySQL();
        Floor c = null;
        String sql = "SELECT * FROM tang WHERE mat = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cid);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new Floor(rs.getInt("mat"),rs.getInt("tang"), rs.getInt("sophong"));
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
     
    public Floor getItemName(int mat) {
        conn = lcdb.getConnectMySQL();
        Floor c = null;
        String sql = "SELECT * FROM tang WHERE mat = ? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, mat);
            rs = pst.executeQuery();
            if (rs.next()) {
                c = new Floor(rs.getInt("mat"),rs.getInt("tang"), rs.getInt("sophong"));
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
     
    public int addItem(Floor item) {
        int result = 0;
        conn = lcdb.getConnectMySQL();

        String sql = "INSERT INTO tang(tang,sophong) VALUES (?,?)";
        try {
            pst = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, item.getTang());
            pst.setInt(2, item.getSoPhong());
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
    
    public int editItem(Floor c) {
        int result = 0;
        conn = lcdb.getConnectMySQL();
        String sql = "UPDATE tang SET tang=?,sophong = ? WHERE mat=? LIMIT 1";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, c.getTang());
            pst.setInt(2, c.getSoPhong());
            pst.setInt(3, c.getMaT());
            pst.executeUpdate();
            result = c.getMaT();
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

        String sql = "DELETE FROM tang WHERE mat = ? LIMIT 1";
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
