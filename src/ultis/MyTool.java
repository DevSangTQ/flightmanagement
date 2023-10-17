/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author AN BAO
 */
public class MyTool {
    /**
     * This method is used for inputting data with String data type.
     * @param msg
     * @return String 
     */
    public static String inputFromKeyBoard(String msg) {
        Scanner sc = new Scanner(System.in);
        String data;
        System.out.print(msg);
        data = sc.nextLine().trim();
        return data;
    }
    /**
     * This method is used for inputting data with pattern(Validation).
     * @param msg
     * @param pattern
     * @return String if inputted data matches with pattern.
     */
    public static String inputWithPattern(String msg, String pattern) {
        String data = inputFromKeyBoard(msg);
        if (data.matches(pattern)) {
            return data;
        }
        return null;
    }
    /**
     * This method is used for checking is valid date or not with pattern.
     * @param inputDate
     * @return true if inputted date is valid.
     */
    public static boolean isValidDate(String inputDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(inputDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * This method is used for inputting Date time with checking valid.
     * @param msg
     * @return Date if it is valid.
     */
    
    public static Date inputDate(String msg) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(msg);
            String input = sc.nextLine();
            sdf.setLenient(false);  // Set lenient to false to enforce strict date parsing
            try {
                date = sdf.parse(input);
                isValid = true;
            } catch (ParseException e) {
                System.out.println("Invalid Date. Enter again!");
                isValid = false;
            }
        }
        return date;
    }
    /**
     * This method is used for reading Boolean
     * @param msg
     * @return True if each of inputted data is True or Yes or 1.
     */
    public static boolean readBol(String msg) {
        String aws;
        aws = inputFromKeyBoard(msg + "[Y/N 1/0 T/F]: ");
        if (aws == null) {
            return true;
        }
        char c = aws.toUpperCase().charAt(0);
        return (c == 'T' || c == '1' || c == 'Y');
    }
    /**
     * This method is used for inputting Integer number.
     * @param msg
     * @return integer number.
     */
    public static int inputInt(String msg) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        try {
            System.out.print(msg);
            result = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number");
        }
        return result;
    }
    /**
     * This method is used for saving binary file(List).
     *
     * @param <T>
     * @param list
     * @param fileName
     */
    public static <T> void saveListToFile(List<T> list, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error saving list to file: " + e.getMessage());
        }
    }

    /**
     * This method is used for loading binary file(list)
     *
     * @param <T>
     * @param list
     * @param fileName
     */
    public static <T> void loadListFromFile(List<T> list, String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            List<T> loadedList = (List<T>) inputStream.readObject();
            list.addAll(loadedList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * this method is used for saving to binary file.
     *
     * @param <K>
     * @param <V>
     * @param map
     * @param fileName
     */
    public static <K, V> void saveMapToFile(Map<K, V> map, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(map);
        } catch (IOException e) {
            System.out.println("Error saving map to file: " + e.getMessage());
        }
    }
    /**
     * This method is used for loading from file in Map.
     * @param <K>
     * @param <V>
     * @param map
     * @param fileName 
     */
    public static <K, V> void loadMapFromFile(Map<K, V> map, String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Map<K, V> loadedMap = (Map<K, V>) inputStream.readObject();
            map.putAll(loadedMap);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
