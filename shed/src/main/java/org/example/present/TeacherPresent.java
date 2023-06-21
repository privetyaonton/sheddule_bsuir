package org.example.present;

import org.example.logic.TableLogic;
import org.example.logic.TeacherLogic;

import java.sql.Connection;
import java.util.Vector;

public class TeacherPresent implements TablePresent{
    private ScannerPresent scannerPresent;
    private TableLogic tableLogic;
    public TeacherPresent (Connection connection, ScannerPresent init_scanner){
        tableLogic = new TeacherLogic(connection);
        scannerPresent = init_scanner;
    }
    public Object[] input(){
        return null;
    }
    public void output (Object[] list){
        String out = list[0] + "\t" + list[2] + " " + list[1] + " " + list[3];
        PrintPresent.printText(out);
    }

    public void insert (){

    }
    public void delete (){

    }
    public void select (){
        Vector<Object[]> out = tableLogic.select();
        for (int i = 0; i < out.size(); i++){
            output(out.elementAt(i));
        }
    }
    public void update (){

    }
}
