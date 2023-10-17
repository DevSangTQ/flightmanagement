/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;


/**
 *
 * @author AN BAO
 */
public class Passenger implements Serializable {
    private String id;
    private String name;
    /**
     * Default Constructor.
     */
    public Passenger() {
    }
    /**
     * Constructor with 2 attributes.
     * @param id
     * @param name 
     */
    public Passenger(String id, String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * This method is used for return ID of passenger.
     * @return 
     */
    public String getId() {
        return id;
    }
    /**
     * This method is used for setting again ID of passenger.
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * This method is used for return name of passenger.
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * This method is used for setting again name of passenger.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method is used for showing information of passenger.
     * @return 
     */
    @Override
    public String toString() {
        return "Passenger{" + "id=" + id + ", name=" + name + '}';
    }
    
}
