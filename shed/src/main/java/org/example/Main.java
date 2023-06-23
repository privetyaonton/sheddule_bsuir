package org.example;

import org.example.present.InvalidInputException;
import org.example.present.MenuPresent;

public class Main {
    public static void main(String[] args) {
        MenuPresent menuPresent = new MenuPresent();
        try{
            menuPresent.menu();
        } catch (InvalidInputException e){
            e.printStackTrace();
        }
    }


}