/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AN BAO
 */
public class Flight implements Serializable {
    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private Date departureTime;
    private Date arrivalTime;
    private int availableSeat;
    private String crew;
    /**
     * Constructor with 6 attributes.
     * @param flightNumber
     * @param departureCity
     * @param destinationCity
     * @param departureTime
     * @param arrivalTime
     * @param availableSeat 
     */
    
    public Flight(String flightNumber, String departureCity, String destinationCity, Date departureTime, Date arrivalTime, int availableSeat, String crew) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeat = availableSeat;
        this.crew = crew;
    }
    /**
     * Getter method
     * @return 
     */
    public String getFlightNumber() {
        return flightNumber;
    }
    /**
     * Setter method
     * @param flightNumber 
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    /**
     * Getter method
     * @return 
     */
    public String getDepartureCity() {
        return departureCity;
    }
    /**
     * Setter method.
     * @param departureCity 
     */
    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }
    /**
     * Getter method
     * @return 
     */
    public String getDestinationCity() {
        return destinationCity;
    }
    /**
     * Setter method
     * @param destinationCity 
     */
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
    /**
     * Getter method.
     * @return 
     */
    public Date getDepartureTime() {
        return departureTime;
    }
    /**
     * Setter method
     * @param departureTime 
     */
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
    /**
     * Getter method
     * @return 
     */
    public Date getArrivalTime() {
        return arrivalTime;
    }
    /**
     * Setter method
     * @param arrivalTime 
     */
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    /**
     * Getter method
     * @return 
     */
    public int getAvailableSeat() {
        return availableSeat;
    }
    /**
     * Setter method
     * @param availableSeat 
     */
    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }
    /**
     * Getter method
     * @return 
     */
    public String getCrew() {
        return crew;
    }
    /**
     * Setter method
     * @param crew 
     */
    public void setCrew(String crew) {
        this.crew = crew;
    }

    
    /**
     * This method is used for showing information of Flight.
     * @return 
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return String.format("|%-16s|%-20s|%-20s|%-20s|%-20s|%16d|\n%s", 
                               flightNumber, departureCity, destinationCity, sdf.format(departureTime), sdf.format(arrivalTime), availableSeat, crew);
        
    }
    
}
