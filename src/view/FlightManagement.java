/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FlightManagementSystem;
import java.io.FileNotFoundException;
import java.util.Date;
import model.Administrator;
import model.AdministratorList;
import model.CheckInList;
import model.Flight;
import model.FlightList;
import model.PassengerList;
import model.ReservationList;
import model.SeatList;
import ultis.MyTool;

/**
 *
 * @author AN BAO
 */
public class FlightManagement {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     *
     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] options = {"Flight schedule management",
            "Passenger Reservation and Booking"};
        System.out.println("Flight Management");
        AdministratorList list = new AdministratorList();
        list.loadAdministratorsFromFile("admin.txt");
        int choice = 0;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    System.out.println("Login Your Administrator Please!");
                    String userName = MyTool.inputFromKeyBoard("Enter the user name (admin01): ");
                    String password = MyTool.inputFromKeyBoard("Enter the password (123456): ");
                    for (Administrator administrator : list) {
                        if(administrator.getNameAccount().equals(userName) && administrator.getPassword().equals(password)){
                            scheduleFlight();
                        }else{
                            System.out.println("Check your account again!");
                        }
                    }
                    break;
                case 2:
                    reservingNBooking();
                    break;
                default:
                    System.out.println("Good Bye!");
                
            }
        } while (choice > 0 && choice < 2);
    }
    /**
     * This method is used for administrator creating and managing flight system. 
     * @throws FileNotFoundException 
     */
    public static void scheduleFlight() throws FileNotFoundException  {
        String[] options = {"Add New Flights",
            "Save Flight To File", "Show All FLight", "Show All Reservation"};
        FLightSystemView view = new FLightSystemView();
        FlightList listFlight = new FlightList();
        ReservationList rl = new ReservationList();
        PassengerList listPassenger = new PassengerList();
        FlightManagementSystem fms = new FlightManagementSystem(listFlight, rl, listPassenger, view);
        listFlight.loadFlightsFromFile("flight.dat");
        rl.loadReservationList("reservation.dat");
        int choice;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    Flight seletectedFlight = view.inputFlightInformation(listFlight);
                    fms.createNewFlights(seletectedFlight.getFlightNumber(), seletectedFlight);
                    break;
                case 2:
                    boolean stt;
                    stt = MyTool.readBol("Do you want to save Flights to file? ");
                    if (stt) {
                        listFlight.storeFlightsToFile("flight.dat");
                        System.out.println("Save Successfully!");
                    }
                    break;
                case 3:
                    listFlight.showAllFlights(listFlight);
                    break;
                case 4:
                    fms.printAllReservations(rl);
                    break;

            }

        } while (choice > 0 && choice < 4);

    }
    /**
     * This method is used for passenger reserving and check in for seat.
     * @throws FileNotFoundException 
     */
    public static void reservingNBooking() throws FileNotFoundException  {
        String[] options = {"Passenger Reservation",
        "Check - In For Getting Seat"};
        FLightSystemView view = new FLightSystemView();
        FlightList listFlight = new FlightList();
        ReservationList rl = new ReservationList();
        PassengerList listPassenger = new PassengerList();
        FlightManagementSystem fms = new FlightManagementSystem(listFlight, rl, listPassenger, view);
        CheckInList listCheckIn = new CheckInList();
        SeatList listSeat = new SeatList();
        listFlight.loadFlightsFromFile("flight.dat");
        rl.loadReservationList("reservation.dat");
        listSeat.loadFromFile("seat.dat");
        listCheckIn.loadFromFile("checkinlist.dat");
        int choice;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    listFlight.showAllFlights(listFlight);
                    String departureCity = MyTool.inputWithPattern("Enter Departure City: ", "^[A-Za-z\\s]+$").toUpperCase();
                    String destinationCity = MyTool.inputWithPattern("Enter Destination City: ", "^[A-Za-z\\s]+$").toUpperCase();
                    //input departure/arrival time
                    Date departureTime = MyTool.inputDate("Enter Departure Time (dd/MM/yyyy): ");
                    fms.reserving(departureCity, destinationCity, departureTime);
                    break;
                case 2:
                    fms.bookingFlight(rl, listSeat, listCheckIn);
                    break;
            }
        } while (choice > 0 && choice < 3);
    }
}
