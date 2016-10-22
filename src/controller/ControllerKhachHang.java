/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.KhachHang;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelKhachHang;
import model.ModelLoaiThanhVien;

/**
 *
 * @author vuongluis
 */
public class ControllerKhachHang extends AbstractTableModel{
    
    private JTable table;
    private ModelKhachHang model;
    private String[] cols = {
        "<html><center><p style='color:#00434a;font-weight:bold;'>STT</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Tên Khách Hàng</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Giới Tính</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Ngày Sinh</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Số CMT</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Email</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Địa Chỉ</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Nghề Nghiệp</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Số Điện Thoại</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Quốc Tịch</p></center></html>",
        "<html><center><p style='color:#00434a;font-weight:bold;'>Loại Thành Viên</p></center></html>"
            
    };
    private ArrayList<KhachHang> alItem = new ArrayList<KhachHang>();
    
    public ControllerKhachHang(JTable table){
        this.table = table;
        model = new ModelKhachHang();
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
        KhachHang Item = alItem.get(rowIndex);
        Object object = null;
        switch(columnIndex){
            case 0:
                object = Item.getMaKH();
                break;
            case 1:
                object = Item.getTenKhachHang();
                break;
            case 2:
                object = Item.getGioiTinh();
                break;
            case 3:
                object = new SimpleDateFormat("dd/MM/yyyy").format(Item.getNgaySinh());
                break;
            case 4:
                object = Item.getSoCMT();
                break;
            case 5:
                object = Item.getThuDienTu();
                break;
            case 6:
                object = Item.getDiaChi();
                break;
            case 7:
                object = Item.getNgheNghiep();
                break;
            case 8:
                object = Item.getSoDienThoai();
                break;
            case 9:
                object = Item.getQuocTich();
                break;
            case 10:
                object = new ModelLoaiThanhVien().getItem(Item.getMaTV()).getTenThanhVien();
                break;
        }
        return object;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0){
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
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(40);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(200);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(100);
        table.getColumnModel().getColumn(9).setPreferredWidth(60);
        table.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    public int addItem(KhachHang obj) {
        // thêm vào database
        int result = model.addItem(obj);
        // thêm vào model
        obj.setMaKH(result);
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

    public int editItem(KhachHang obj, int row) {
        // sữa trong database
        int id = model.editItem(obj);
        // sữa trong model
        obj.setMaKH(id);
        int rowModel=table.convertRowIndexToModel(row);
        alItem.set(rowModel,obj);
        this.fireTableDataChanged();
        return id;
    }
}
