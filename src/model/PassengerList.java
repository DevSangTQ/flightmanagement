/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author AN BAO
 */
public class PassengerList extends HashMap<String, Passenger> implements Serializable {
    /**
     * Default constructor of PassegerList class.
     */
    public PassengerList() {
    }
    /**
     * This method is user for adding new Passenger to list.
     * @param passengerID
     * @param passenger 
     */
    public void addPassenger(String passengerID, Passenger passenger){
        this.put(passengerID, passenger);
    }
    
}
