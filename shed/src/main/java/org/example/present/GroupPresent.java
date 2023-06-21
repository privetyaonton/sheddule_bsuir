package org.example.present;

import org.example.logic.GroupLogic;
import org.example.logic.TableLogic;

import java.sql.Connection;
import java.util.Vector;

public class GroupPresent implements TablePresent{
    private TableLogic tableLogic;
    private ScannerPresent scannerPresent;
    public GroupPresent (Connection connection, ScannerPresent init_scanner){
        tableLogic = new GroupLogic(connection);
        scannerPresent = init_scanner;
    }
    public Object[] input(){
        return null;
    }
    public void output (Object[] list){
        String out = list[0] + "\t" + list[1];
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
