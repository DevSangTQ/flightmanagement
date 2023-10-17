/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author AN BAO
 */
public class Reservation implements Serializable {

    private String reservationID;
    private final Flight flight;
    private final Passenger passenger;
    private final Date bookingDate; //doesnt have setter method
    private String seat = "";
    /**
     * Constructor with 3 attributes.
     * @param flight
     * @param passenger
     */
    public Reservation(Flight flight, Passenger passenger) {
        this.bookingDate = new Date();
        this.reservationID = UUID.randomUUID().toString();
        this.flight = flight;
        this.passenger = passenger;
    }
    
    /**
     * This method is used for return reservationID
     * @return String
     */
    public String getReservationID() {
        return reservationID;
    }
    /**
     * This method is used for set reservationID
     * @param reservationID 
     */
    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }
    /**
     * This method is used for getting date of booking.
     * @return 
     */
    public Date getBookingDate() {
        return bookingDate;
    }
    /**
     * This method is used for getting Flight
     * @return 
     */
    public Flight getFlight() {
        return flight;
    }
    /**
     * This method is used for getting passenger.
     * @return 
     */
    public Passenger getPassenger() {
        return passenger;
    }
    /**
     * Getter method
     * @return 
     */
    public String getSeat() {
        return seat;
    }
    /**
     * Setter method
     * @param seat 
     */
    public void setSeat(String seat) {
        this.seat = seat;
    }
    
    /**
     * This method is used for print out reservation.
     * @param flight
     * @param passenger
     */
    public void printReservation(Flight flight, Passenger passenger){
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    System.out.println(" ****************************************************");
    System.out.println("                    BOARDING PASS                    ");
    System.out.println(" ****************************************************");
    System.out.println(" Reservation ID: " + getReservationID());
    System.out.println(" Booking Date: " + getBookingDate());
    System.out.println(" Seat: " + getSeat());
    System.out.println(" Passenger ID: " + passenger.getId());
    System.out.println(" Passenger Name: " + passenger.getName());
    System.out.println(" Flight Number: " + flight.getFlightNumber());
    System.out.println(" Departure Time: " + sdf.format(flight.getDepartureTime()));
    System.out.println(" Departure City: " + flight.getDepartureCity());
    System.out.println(" Destination City: " + flight.getDestinationCity());
    System.out.println("*****************************************************");
}

}
