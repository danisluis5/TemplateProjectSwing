/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.TypeRoom;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelLoaiPhong;
import render.LoaiPhongComboboxModel;

/**
 *
 * @author vuongluis
 */
public class ControllerLoaiPhong extends AbstractTableModel{
    
    private JTable table;
    private ModelLoaiPhong model;
    private String[] cols = {
        "<html><center><p style='color:#00434a;font-weight:bold;'>STT</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Tên Loại Phòng</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Đơn Giá</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Mô tả</p></center></html>"
    };
    private ArrayList<TypeRoom> alItem = new ArrayList<TypeRoom>();
    
    public ControllerLoaiPhong(JTable table){
        this.table = table;
        model = new ModelLoaiPhong();
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
        TypeRoom Item = alItem.get(rowIndex);
        Object object = null;
        switch(columnIndex){
            case 0:
                object = Item.getMaLP();
                break;
            case 1:
                object = Item.getTenPhong();
                break;
            case 2:
                object = Item.getDonGia();
                break;
            case 3:
                object = Item.getMoTa();
                break;
        }
        return object;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0){
            return Integer.class;
        }else if(columnIndex == 2){
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
        
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(20);
        table.getColumnModel().getColumn(2).setPreferredWidth(20);
        table.getColumnModel().getColumn(3).setPreferredWidth(500);
    }

    public int addItem(TypeRoom obj) {
        // thêm vào database
        int result = model.addItem(obj);
        // thêm vào model
        obj.setMaLP(result);
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

    public int editItem(TypeRoom obj, int row) {
        // sữa trong database
        int id = model.editItem(obj);
        // sữa trong model
        obj.setMaLP(id);
        int rowModel=table.convertRowIndexToModel(row);
        alItem.set(rowModel,obj);
        this.fireTableDataChanged();
        return id;
    }
    public void loadCategory(JComboBox<TypeRoom> cbLoaiPhong, boolean isSearch, TypeRoom obj) {
        cbLoaiPhong.setModel(new LoaiPhongComboboxModel(isSearch,obj));
    }
}
