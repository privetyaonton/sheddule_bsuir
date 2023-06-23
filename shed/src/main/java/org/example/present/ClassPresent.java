package org.example.present;

import org.example.logic.*;

import java.sql.Connection;
import java.util.Scanner;
import java.util.Vector;

public class ClassPresent implements TablePresent{

    private TableLogic tableLogic;
    private ScannerPresent scannerPresent;
    private Connection this_connection;
    public ClassPresent (Connection connection, ScannerPresent init_scanner){
        tableLogic = new ClassLogic(connection);
        scannerPresent = init_scanner;
        this_connection = connection;
    }
    public Object[] input(){
        Object[] list = new Object[6];
        PrintPresent.printText("Все доступные группы:");
        PrintPresent.printText("ID\tНомер группы");
        TablePresent tablePresent = new GroupPresent(this_connection, scannerPresent);
        tablePresent.select();

        PrintPresent.printText("Введите ID группы:\n");
        list[0] = scannerPresent.getInt();

        TableLogic tableLogicTemp = new GroupLogic(this_connection);
        try{
            tableLogicTemp.select((int)list[0]);
        } catch (UndefindedIndexException e){
            PrintPresent.printText("Несуществующий индекс");
            return null;
        }

        PrintPresent.printText("Все доступные преподаватели:");
        PrintPresent.printText("ID\tФИО");
        tablePresent = new TeacherPresent(this_connection, scannerPresent);
        tablePresent.select();

        PrintPresent.printText("Введите ID преподавателя:\n");
        list[1] = scannerPresent.getInt();

        tableLogicTemp = new TeacherLogic(this_connection);
        try{
            tableLogicTemp.select((int)list[1]);
        } catch (UndefindedIndexException e){
            PrintPresent.printText("Несуществующий индекс");
            return null;
        }

        PrintPresent.printText("Все доступные дисциплины:");
        PrintPresent.printText("ID\tНазвание");
        tablePresent = new AcademicSubjectPresent(this_connection, scannerPresent);
        tablePresent.select();

        PrintPresent.printText("Введите ID дисциплины\n");
        list[2] = scannerPresent.getInt();

        tableLogicTemp = new AcademicSubjectLogic(this_connection);
        try{
            tableLogicTemp.select((int)list[2]);
        } catch (UndefindedIndexException e){
            PrintPresent.printText("Несуществующий индекс");
            return null;
        }

        PrintPresent.printText("Введите аудиторию:\n");
        list[3] = scannerPresent.getString();
        PrintPresent.printText("Введите время начала занятия (hh:mm):\n");
        list[4] = scannerPresent.getString();
        PrintPresent.printText("Введите время окончания занятия (hh:mm):\n");
        list[5] = scannerPresent.getString();

        return list;
    }
    public void output (Object[] list){
        String out = list[0] + "\t" +
                list[1] + "\t" + list[2] + "\t" +
                list[3] + "\t" + list[4] + "\t" +
                list[5] + "\t" + list[6] + "\n";
        PrintPresent.printText(out);
    }

    public void insert (){
        Object[] list = input();
        if (list == null) return;
        tableLogic.insert(input());
    }
    public void delete (){
        PrintPresent.printText("ID занятия:\n");
        int id = scannerPresent.getInt();
        tableLogic.delete(id);

    }
    public void select (){
        Vector<Object[]> out = tableLogic.select();
        PrintPresent.printText("ID Занятия\tID Группы\tID преподавателя\t" +
                "ID дисциплины\tАудитория\tНачало\tКонец\n");
        if (out == null) return;
        for (int i = 0; i < out.size(); i++){
            output(out.elementAt(i));
        }
    }
    public void update (){
        Object[] in = input();
        if (in == null) return;
        PrintPresent.printText("Введите ID занятия:\n");
        int id = scannerPresent.getInt();
        tableLogic.update(id, in);
    }
}
