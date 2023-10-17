/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AN BAO
 */
public class AdministratorList extends ArrayList<Administrator> {
    /**
     * Default constructor.
     */
    public AdministratorList() {
    }
    /**
     * This method is used for loading account from file.
     * @param filename
     */
    public void loadAdministratorsFromFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename)); //read all lines from file

            for (String line : lines) {
                String[] parts = line.split(" ");
                String nameAccount = parts[0];
                String password = parts[1];
                Administrator admin = new Administrator(nameAccount, password);
                this.add(admin);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
