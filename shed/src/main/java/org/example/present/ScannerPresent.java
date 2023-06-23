package org.example.present;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerPresent {
    private Scanner scanner;
    public ScannerPresent (){
        scanner = new Scanner(System.in);
    }
    public int getInt(){
        int input = 0;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e){
            scanner.nextLine();
            PrintPresent.printText("Неправильный ввод");
            return getInt();
        }
        scanner.nextLine();
        return input;
    }
    public String getString(){
        return scanner.nextLine();
    }
}
