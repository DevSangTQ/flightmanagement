/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author AN BAO
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import ultis.MyTool;

public class SeatList implements Serializable {
    private Map<String, Flight> seatToFlightMap;
    /**
     * Default constructor with method is used for creating a HashMap to save the seat with each flight.
     */
    public SeatList() {
        this.seatToFlightMap = new HashMap<>();
    }
    /**
     * This method is used for passenger selecting Seat.
     * @param flight
     * @return seat if seat is not null
     */
    public String selectSeat(Flight flight) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter seat (e.g., A1): ");
        String seat = scanner.nextLine();

        String seatNumber = flight.getFlightNumber() + seat;
        if (!seatToFlightMap.containsKey(seatNumber)) {
            seatToFlightMap.put(seatNumber, flight); 
            return seat;
        } else {
            System.out.println("Seat " + seat + " is already taken.");
            return null;
        }
    }
    /**
     * This method is used for displaying the map seat of Flight.
     * @param flight 
     */
    public void displaySeats(Flight flight) {
        int numRows = flight.getAvailableSeat() / 5;
        String[][] seats = new String[numRows][5];
        char rowChar = 'A';

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < 5; j++) {
                String seatNumber = String.valueOf(rowChar) + (j + 1);
                if (seatToFlightMap.containsKey(flight.getFlightNumber() + seatNumber)) {
                    seats[i][j] = "X"; // Seat is taken
                } else {
                    seats[i][j] = seatNumber; // Seat is available
                }
            }
            rowChar++;
        }

        System.out.println("Flight: " + flight.getFlightNumber());
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method is used for saving to file.
     * @param file 
     */
    public void storeListToFile(String file) {
        MyTool.saveMapToFile(seatToFlightMap, file);
    }
    /**
     * This method is used for loading from file.
     * @param file 
     */
    public void loadFromFile(String file) {
        MyTool.loadMapFromFile(seatToFlightMap, file);
    }
    
}
