package org.example.present;

import org.example.logic.TableLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MenuPresent {
    public MenuPresent(){
        scannerPresent = new ScannerPresent();
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "RAnton22";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    public void menu() throws InvalidInputException {
        int cont = 1;
        while (cont == 1) {
            PrintPresent.printText("Выберите таблицу:\n" +
                    "1) Занятия\n" +
                    "2) Дни недели\n" +
                    "3) Их промежуточная таблица\n");
            int choose = scannerPresent.getInt();
            TablePresent tablePresent;
            switch (choose) {
                case 1:
                    tablePresent = new ClassPresent(connection, scannerPresent);
                    break;
                case 2:
                    tablePresent = new DayPresent(connection, scannerPresent);
                    break;
                case 3:
                    tablePresent = new DayClassPresent(connection, scannerPresent);
                    break;
                default:
                    throw new InvalidInputException();
            }
            PrintPresent.printText("Выберите действие с таблицей\n" +
                    "1) Добавить запись\n" +
                    "2) Удалить запись\n" +
                    "3) Просмотреть\n" +
                    "4) Изменить запись\n");
            choose = scannerPresent.getInt();
            switch (choose) {
                case 1:
                    tablePresent.insert();
                    break;
                case 2:
                    tablePresent.delete();
                    break;
                case 3:
                    tablePresent.select();
                    break;
                case 4:
                    tablePresent.update();
                    break;
                default:
                    throw new InvalidInputException();
            }

            PrintPresent.printText("Продолжить? (1 - да, 0 - нет)\n");
            cont = scannerPresent.getInt();
        }
    }
    private ScannerPresent scannerPresent;
    private TablePresent tablePresent;
    private Connection connection;


}
