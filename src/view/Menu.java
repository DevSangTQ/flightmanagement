/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author AN BAO
 */
public class Menu {
     public static int getChoice(String[] options){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + "-" + options[i]);
        }
        System.out.print("Choose 1.." + options.length + ": ");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
}
