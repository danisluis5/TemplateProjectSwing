/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Room;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelLoaiPhong;
import model.ModelRoom;

/**
 *
 * @author vuongluis
 */
public class ControllerRoom extends AbstractTableModel{
    
    private JTable table;
    private ModelRoom model;
    private String[] cols = {
        "<html><center><p style='color:#00434a;font-weight:bold;'>STT</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Số Phòng</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Tình Trạng</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Trạng Thái</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Ghi Chú</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Loại Phòng</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Tầng</p></center></html>"
            
    };
    private ArrayList<Room> alItem = new ArrayList<Room>();
    
    public ControllerRoom(JTable table){
        this.table = table;
        model = new ModelRoom();
        alItem = model.getList();
    }
    @Override
    public int getRowCount() {
        return alItem.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Room Item = alItem.get(rowIndex);
        Object object = null;
        switch(columnIndex){
            case 0:
                object = Item.getMaP();
                break;
            case 1:
                object = Item.getSoPhong();
                break;
            case 2:
                object = Item.getTinhtrang();
                break;
            case 3:
                object = Item.getTrangThai();
                break;
            case 4:
                object = Item.getGhiChu();
                break;
            case 5:
                object = new ModelLoaiPhong().getItem(Item.getMaLP()).getTenPhong();
                break;
            case 6:
                object = Item.getTang();
                break;
        }
        return object;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0){
            return Integer.class;
        }else if(columnIndex == 1){
            return Integer.class;
        }else if(columnIndex == 6){
            return Integer.class;
        }
        return super.getColumnClass(columnIndex); 
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return super.isCellEditable(rowIndex, columnIndex); 
    }
    
    public void loadTable(){
        
        this.table.setModel(this);
        this.table.setAutoCreateRowSorter(true);
        
        table.getTableHeader().setPreferredSize(new Dimension(0, 30));
        table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD, 12));
        table.setRowHeight(26);
        table.setFont(new Font("Tahoma",Font.PLAIN, 12));
        
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(260);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
    }

    public int addItem(Room obj) {
        // thêm vào database
        int result = model.addItem(obj);
        // thêm vào model
        obj.setMaP(result);
        alItem.add(obj);
        this.fireTableDataChanged();
        table.scrollRectToVisible(table.getCellRect(this.getRowCount()-1, 0, true));
        return result;
    }

    public int delItem(int id, int row) {
        // xóa trong database
        int result = model.delItem(id);
        // xóa trong model
        int rowmodel = table.convertRowIndexToModel(row);
        alItem.remove(rowmodel);
        this.fireTableDataChanged();
        return result;
    }

    public int editItem(Room obj, int row) {
        // sữa trong database
        int id = model.editItem(obj);
        // sữa trong model
        obj.setMaP(id);
        int rowModel=table.convertRowIndexToModel(row);
        alItem.set(rowModel,obj);
        this.fireTableDataChanged();
        return id;
    }
//    public void loadCategory(JComboBox<Category> cbDanhMuc, boolean isSearch, Category objCat) {
//        cbDanhMuc.setModel(new RenderComboBoxModelCat(isSearch,objCat));
//    }
}
