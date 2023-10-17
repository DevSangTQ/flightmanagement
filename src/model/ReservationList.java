/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import ultis.MyTool;

/**
 *
 * @author AN BAO
 */
public class ReservationList extends ArrayList<Reservation> implements Serializable {
    /**
     * Default constructor of ReservationList class.
     */
    public ReservationList() {
    }
    /**
     * This method is used for adding new Reservation to list.
     * @param reservation 
     */
    public void addReservation(Reservation reservation){
        this.add(reservation);
    }
    /**
     * This method is used for saving reservation list to file.
     * @param file 
     */
    public void saveReservationList(String file){
        MyTool.saveListToFile(this, file);
    }
    /**
     * This method is used for loading from file.
     * @param file 
     */
    public void loadReservationList(String file) {
        MyTool.loadListFromFile(this, file);
    }
  
}
