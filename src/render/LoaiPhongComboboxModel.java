/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render;

import bean.TypeRoom;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import model.ModelLoaiPhong;

/**
 *
 * @author vuongluis
 */
public class LoaiPhongComboboxModel implements ComboBoxModel<TypeRoom>{

    private ArrayList<TypeRoom> alItems = new ArrayList<TypeRoom>();
    private ModelLoaiPhong model;
    private TypeRoom selectedItem = new TypeRoom();
    
    public LoaiPhongComboboxModel(boolean isSearch, TypeRoom obj) {
        model = new ModelLoaiPhong();
        alItems = model.getList();
        if(obj == null){
            selectedItem = alItems.get(0);
        }else{
            selectedItem = obj;
        }
    }
    
    public LoaiPhongComboboxModel(){
        model = new ModelLoaiPhong();
        alItems = model.getList();
        selectedItem = alItems.get(0);
    }
    
    public LoaiPhongComboboxModel(String loaiPhong){
        model = new ModelLoaiPhong();
        alItems = model.getList();
        for(int i = 0; i < alItems.size(); i++){
            if(alItems.get(i).getTenPhong().equals(loaiPhong)){
                selectedItem = alItems.get(i);
            }
        }
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (TypeRoom) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return alItems.size();
    }

    public TypeRoom getElementAt(int index) {
        return alItems.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }
    
}
