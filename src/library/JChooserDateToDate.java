/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author vuongluis
 */
public class JChooserDateToDate {
    public Date getTime(Date temp){
        int month = 0;
        ArrayList<String> alItems = new ArrayList<String>();
        for(String s: temp.toString().split(" ")){
                alItems.add(s);               
        }
        switch(alItems.get(1)){
            case "Jan":
                month = 1;
                break;
            case "Feb":
                month = 2;
                break;
            case "Mar":
                month = 3;
                break;
            case "Apr":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "Jun":
                month = 6;
                break;
            case "Jul":
                month = 7;
                break;
            case "Aug":
                month = 8;
                break;
            case "Sep":
                month = 9;
                break;
            case "Oct":
                month = 10;
                break;
            case "Nov":
                month = 11;
                break;
            case "Dec":
                month = 12;
                break;
        }
        return new Date(Integer.parseInt(alItems.get(5))-1900, month-1, Integer.parseInt(alItems.get(2)), 0, 0,0);
    }
}
