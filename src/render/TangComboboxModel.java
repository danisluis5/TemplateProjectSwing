/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package render;

import bean.Floor;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import model.ModelLoaiPhong;
import model.ModelTang;

/**
 *
 * @author vuongluis
 */
public class TangComboboxModel implements ComboBoxModel<Floor>{

    private ArrayList<Floor> alItems = new ArrayList<Floor>();
    private ModelTang model;
    private Floor selectedItem = new Floor();
    
    public TangComboboxModel(boolean isSearch, Floor obj) {
        model = new ModelTang();
        alItems = model.getList();
        if(obj == null){
            selectedItem = alItems.get(0);
        }else{
            selectedItem = obj;
        }
    }
    public TangComboboxModel(){
        model = new ModelTang();
        alItems = model.getList();
        selectedItem = alItems.get(0);
    }
    
    public TangComboboxModel(int tang){
        model = new ModelTang();
        alItems = model.getList();
        for(int i = 0; i < alItems.size(); i++){
            if(alItems.get(i).getTang() == tang){
                selectedItem = alItems.get(i);
            }
        }
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Floor) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return alItems.size();
    }

    public Floor getElementAt(int index) {
        return alItems.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }
    
}
