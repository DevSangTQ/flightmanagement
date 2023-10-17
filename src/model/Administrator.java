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
public class Administrator {
    private String nameAccount;
    private String password;
   
    /**
     * Constructor with 2 attributes.
     * @param nameAccount
     * @param password 
     */
    public Administrator(String nameAccount, String password) {
        this.nameAccount = nameAccount;
        this.password = password;
    }
    /**
     * Getter method
     * @return nameAccount
     */
    public String getNameAccount() {
        return nameAccount;
    }
    /**
     * Setter method
     * @param nameAccount 
     */
    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }
    /**
     * Getter method
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Setter method
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
