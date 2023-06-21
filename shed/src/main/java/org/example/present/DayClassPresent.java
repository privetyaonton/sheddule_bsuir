package org.example.present;

import org.example.logic.DayClassLogic;
import org.example.logic.TableLogic;

import java.sql.Connection;
import java.util.Vector;

public class DayClassPresent implements TablePresent{
    private TableLogic tableLogic;
    private ScannerPresent scannerPresent;
    public DayClassPresent (Connection connection, ScannerPresent init_scanner){
        tableLogic = new DayClassLogic(connection);
        scannerPresent = init_scanner;
    }
    public Object[] input(){
        Object[] list = new Object[2];
        PrintPresent.printText("ID занятия:\n");
        list[1] = scannerPresent.getInt();
        PrintPresent.printText("ID дня:\n");
        list[0] = scannerPresent.getInt();
        return list;
    }
    public void output (Object[] list){
        String out = list[0] + "\t" + list[1] + "\t" + list[2] + "\n";
        PrintPresent.printText(out);
    }

    public void insert (){
        tableLogic.insert(input());
    }
    public void delete (){
        PrintPresent.printText("Введите ID:\n");
        int id = scannerPresent.getInt();
        tableLogic.delete(id);
    }
    public void select (){
        Vector<Object[]> out = tableLogic.select();
        PrintPresent.printText("ID\tID дня\tID занятия\n");
        for (int i = 0; i < out.size(); i++){
            output(out.elementAt(i));
        }
    }
    public void update (){
        Object[] in = input();
        PrintPresent.printText("Введите ID:\n");
        int id = scannerPresent.getInt();
        tableLogic.update(id, in);
    }
}
