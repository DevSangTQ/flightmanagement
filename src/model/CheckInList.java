/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import ultis.MyTool;

/**
 *
 * @author AN BAO
 */
public class CheckInList extends ArrayList<Reservation> {

    /**
     * Default constructor.
     */
    public CheckInList() {
    }
    /**
     * This method is used for add reservation to Check - In list.
     * @param reserv 
     */
    public void addReservation(Reservation reserv){
        this.add(reserv);
        storeFile("checkinlist.dat");
    }
    /**
     * This method is used for loading from file
     * @param file 
     */
    public void loadFromFile(String file){
        MyTool.loadListFromFile(this, file);
    }
    /**
     * This method is used for saving reservation to file.
     * @param file 
     */
    public void storeFile(String file){
        MyTool.saveListToFile(this, file);
    }
}
