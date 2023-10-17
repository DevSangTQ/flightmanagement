/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import ultis.MyTool;

/**
 *
 * @author AN BAO
 */
public class FlightList extends HashMap<String, Flight> implements Serializable {

    /**
     * Default Constructor of FlightList class.
     */
    public FlightList() {
    }

    /**
     * This method is user for creating new Flight
     *
     * @param fNumber
     * @param flight
     */
    public void createNewFlight(String fNumber, Flight flight) {
        this.put(fNumber, flight);
    }
      /**
     * This method is used for saving Flight list to file.
     * @param fileName 
     */
    public void storeFlightsToFile(String fileName) {
        MyTool.saveMapToFile(this, fileName);
    }
    /**
     * This method is used for loading list from file.
     * @param fileName
     * @throws java.io.FileNotFoundException
     */
    public void loadFlightsFromFile(String fileName) throws FileNotFoundException{
        MyTool.loadMapFromFile(this, fileName);
    }
    /**
     * This method is used for showing all flights.
     * @param list 
     */
    public void showAllFlights(FlightList list) {
        System.out.println("|Flight Number   |Departure City      |Destination City    |Departure Time      |Arrival Time        |Available Seat  |");
        for (Flight flight : list.values()) {
            System.out.println(flight);
        }
    }
}
