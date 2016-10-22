/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render;

import bean.LoaiThanhVien;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import model.ModelLoaiPhong;
import model.ModelLoaiThanhVien;

/**
 *
 * @author vuongluis
 */
public class LoaiThanhVienComboboxModel implements ComboBoxModel<LoaiThanhVien>{

    private ArrayList<LoaiThanhVien> alItems = new ArrayList<LoaiThanhVien>();
    private ModelLoaiThanhVien model;
    private LoaiThanhVien selectedItem = new LoaiThanhVien();
    
    public LoaiThanhVienComboboxModel(boolean isSearch, LoaiThanhVien obj) {
        model = new ModelLoaiThanhVien();
        alItems = model.getList();
        if(obj == null){
            selectedItem = alItems.get(0);
        }else{
            selectedItem = obj;
        }
    }
    
    public LoaiThanhVienComboboxModel(){
        model = new ModelLoaiThanhVien();
        alItems = model.getList();
        selectedItem = alItems.get(0);
    }
    
    public LoaiThanhVienComboboxModel(String loaiThanhVien){
        model = new ModelLoaiThanhVien();
        alItems = model.getList();
        for(int i = 0; i < alItems.size(); i++){
            if(alItems.get(i).getTenThanhVien().equals(loaiThanhVien)){
                selectedItem = alItems.get(i);
            }
        }
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (LoaiThanhVien) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return alItems.size();
    }

    public LoaiThanhVien getElementAt(int index) {
        return alItems.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }
    
}
