package org.example.present;

import org.example.logic.DayLogic;
import org.example.logic.TableLogic;

import java.sql.Connection;
import java.util.Vector;

public class DayPresent implements TablePresent{
    private TableLogic tableLogic;
    private ScannerPresent scannerPresent;
    public DayPresent (Connection connection, ScannerPresent init_scanner){
        tableLogic = new DayLogic(connection);
        scannerPresent = init_scanner;
    }
    public Object[] input(){
        Object[] list = new Object[1];
        PrintPresent.printText("Номер дня в неделе:\n");
        list[0] = scannerPresent.getInt();
        return list;
    }
    public void output (Object[] list){
        String out = list[0] + "\t" + list[1] + "\n";
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
        PrintPresent.printText("ID дня\tНомер дня\n");
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
