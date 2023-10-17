/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import model.Flight;
import model.FlightList;
import model.Passenger;
import model.PassengerList;
import ultis.MyTool;

/**
 *
 * @author AN BAO
 */
public class FLightSystemView {
    /**
     * Default constructor.
     */
    public FLightSystemView() {
    }
    
    /**
     * This method is used for inputting Flight information from user.
     * @param list
     * @return Flight
     */
    public Flight inputFlightInformation(FlightList list){
        String flightNumber, departureCity, destinationCity;
        Date departureTime, arrivalTime;
        int availableSeat;
        boolean isLoop = true;
        //input flight number
        do {
            flightNumber = MyTool.inputFromKeyBoard("Enter Flight Number (F0000): ").toUpperCase();
            if (flightNumber.matches("[Ff]\\d{4}")) {
                if (list.containsKey(flightNumber)) {
                    System.out.println("The Flight Number has existed!");
                    isLoop = true;
                } else {
                    isLoop = false; // Set isDuplicated to false when the flight number is not duplicated
                }
            } else {
                System.out.println("Invalid Flight Number. Please try again.");
            }
        } while (isLoop);
        //input departure/destination city
        departureCity = MyTool.inputWithPattern("Enter Departure City: ", "^[A-Za-z\\s]+$").toUpperCase();
        destinationCity = MyTool.inputWithPattern("Enter Destination City: ", "^[A-Za-z\\s]+$").toUpperCase();
        //input departure/arrival time
        departureTime = MyTool.inputDate("Enter Departure Time (dd/MM/yyyy): ");
        arrivalTime = MyTool.inputDate("Enter Arrival Time (dd/MM/yyyy): ");
        //input available seat
        availableSeat = MyTool.inputInt("Enter Available Seat: ");
        //input crew of each flight
        String crew = MyTool.inputFromKeyBoard("Enter the crew of Flight " + flightNumber + ": ");
        Flight flight = new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime, availableSeat, crew);
        return flight;
    }
    /**
     * This method is used for inputting passenger info
     * @param list
     * @return 
     */
    public Passenger inputPassengerInfo(PassengerList list){
        String passengerID;
        boolean isLoop = false;
        do {
            passengerID = MyTool.inputFromKeyBoard("Enter your ID: ");
            if (passengerID.matches("^[0-9]+$")) {
                if (list.containsKey(passengerID)) {
                    System.out.println("The passenger ID has existed!");
                    isLoop = true;
                } else {
                    isLoop = false; // Set isDuplicated to false when the flight number is not duplicated
                }
            } else {
                System.out.println("Invalid Passenger ID. Please try again.");
            }
        } while (isLoop);
        String passengerName = MyTool.inputWithPattern("Enter your name: ", "^[A-Za-z\\s]+$");
        Passenger passenger = new Passenger(passengerID, passengerName);
        return passenger;
    }

  

}

