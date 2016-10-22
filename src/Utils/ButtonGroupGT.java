/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
/**
 *
 * @author vuongluis
 */
public class ButtonGroupGT {
    public String getText(ButtonGroup btGioiTinh){
        String outString = "";
        Enumeration<AbstractButton> el = btGioiTinh.getElements();
        while(el.hasMoreElements()){
            AbstractButton btGT = el.nextElement();
            if(btGT.isSelected()){
                outString = btGT.getText();
            }
        }
        return outString;
    }
    public void setText(ButtonGroup btGioiTinh,String gioiTinh){
        Enumeration<AbstractButton> el = btGioiTinh.getElements();
        while (el.hasMoreElements()) {
            AbstractButton btGT = el.nextElement();
            if(btGT.getText().equals(gioiTinh)){
                btGT.isSelected();
            }
        }
    }
}
