/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.util.Date;
import model.CheckInList;
import model.Flight;
import model.FlightList;
import model.Passenger;
import model.PassengerList;
import model.Reservation;
import model.ReservationList;
import model.SeatList;
import ultis.MyTool;
import view.FLightSystemView;

/**
 *
 * @author AN BAO
 */
public class FlightManagementSystem {

    private FlightList listFlight;
    private ReservationList listReservation;
    private PassengerList listPassenger;
    private FLightSystemView view;
    
    /**
     * Default constructor of FlightManagementSystem class.
     */
    public FlightManagementSystem() {
    }

    /**
     * Constructor with 4 attributes.
     *
     * @param listFlight
     * @param listReservation
     * @param listPassenger
     * @param view
     */
    public FlightManagementSystem(FlightList listFlight, ReservationList listReservation, PassengerList listPassenger, FLightSystemView view) {
        this.listFlight = listFlight;
        this.listReservation = listReservation;
        this.listPassenger = listPassenger;
        this.view = view;
    }

    /**
     * This method is used for creating new Flight.
     *
     *
     * @param fNumber
     * @param flight
     */
    public void createNewFlights(String fNumber, Flight flight) {
        this.listFlight.createNewFlight(fNumber, flight);
        System.out.println("Create Successfully!");
    }
    /**
     * This method is used to return a FLight with constraint.
     * @param departureCity
     * @param arrivalCity
     * @param departureTime
     * @return
     * @throws java.io.FileNotFoundException
     */
    public Flight selectFlight(String departureCity, String arrivalCity, Date departureTime) throws FileNotFoundException{
        Flight selectedFlight = null;
        listFlight.loadFlightsFromFile("flight.dat");
        for (Flight f : listFlight.values()) {
            if (f.getDepartureCity().equalsIgnoreCase(departureCity)&&f.getDestinationCity().equalsIgnoreCase(arrivalCity)&&f.getDepartureTime().equals(departureTime)) {
                selectedFlight = f;
            }
        }
        return selectedFlight;
    }
    /**
     * This method is used for searching Flight in reservation list.
     * @param list
     * @param resvID
     * @return 
     */
    public Reservation searchFlight(ReservationList list, String resvID){
        
        Reservation resv = null;
        for (Reservation reservation : list) {
                if (reservation.getReservationID().equals(resvID)) {
                    resv = reservation;
                }                
            }
        return resv;
    }
    /**
     * This method is used for user finding and reserving seat.
     *
     * @param departureCity
     * @param arrivalCity
     * @param departureTime
     * @throws java.io.FileNotFoundException
     */
    public void reserving(String departureCity, String arrivalCity, Date departureTime) throws FileNotFoundException{    
        Flight seleFlight = selectFlight(departureCity, arrivalCity, departureTime);
        Passenger selectedPassenger;        
        if (seleFlight != null) {
            boolean status = MyTool.readBol("Do you want to reserve seat for this flight?");
            if (status) {
                System.out.println("Please provide your information");
                selectedPassenger = view.inputPassengerInfo(listPassenger);
                listPassenger.addPassenger(selectedPassenger.getId(), selectedPassenger);
                Reservation newReservation = new Reservation(seleFlight, selectedPassenger);
                listReservation.add(newReservation); //add reservation to reservation list
                newReservation.printReservation(seleFlight, selectedPassenger);
                listReservation.saveReservationList("reservation.dat");
            }
        } else {
            System.out.println("Flight not available!");
        }
    }
    /**
     * This method is used for checking whether passenger have checked in or not 
     * @param list
     * @param reservationID
     * @return 
     */
    public boolean isCheckIn(CheckInList list, String reservationID) {
        boolean isCheckIn = false;
        for (Reservation reservation : list) {
            if (reservation.getReservationID().equalsIgnoreCase(reservationID)) {
                isCheckIn = true;
                break;
            }
        }
        return isCheckIn;
    }
    /**
     * This method is used for booking seat for Flight.
     * @param list
     * @param listSeat
     * @param checkInList
     */
    public void bookingFlight(ReservationList list, SeatList listSeat, CheckInList checkInList) { 
        String reservationID = MyTool.inputFromKeyBoard("Enter Reservation ID For Check - in: ");
        if (!isCheckIn(checkInList, reservationID)) {
            Reservation resrv = searchFlight(list, reservationID);
            Flight selectedFlight = resrv.getFlight();
            System.out.println("Seat: " + selectedFlight.getAvailableSeat());
            listSeat.displaySeats(selectedFlight);
            String seat = listSeat.selectSeat(selectedFlight);
            if (seat != null) {
                resrv.setSeat(seat);
                resrv.printReservation(selectedFlight, resrv.getPassenger());
                checkInList.addReservation(resrv);
                listSeat.storeListToFile("seat.dat");
            }
        } else {
            System.out.println("You have check - in already!");
        }

    }
    /**
     * This method is used for print out reservation.
     * @param list 
     */
    public void printAllReservations(ReservationList list){
        for (Reservation reservation : list) {
            reservation.printReservation(reservation.getFlight(), reservation.getPassenger());
        }
    }
}


