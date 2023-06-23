package org.example.logic;

import org.example.data.DayDAO;
import org.example.data.TableDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DayLogic implements TableLogic{
    public DayLogic (Connection init_connection){
        connection = init_connection;
        dayLogicInterface = new DayDAO();
    }
    private Connection connection;
    private TableDAO dayLogicInterface;

    public void insert (Object[] list){
        try{
            dayLogicInterface.insert(list, connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete (int id){
        try{
            dayLogicInterface.delete(id, connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Vector<Object[]> select (){
        Vector<Object[]> result = new Vector<Object[]>();
        try{
            ResultSet resultSet = dayLogicInterface.select(connection);
            for (int i = 0; resultSet.next(); i++){
                result.add(new Object[2]);
                result.elementAt(i)[0] = resultSet.getInt(1);
                result.elementAt(i)[1] = resultSet.getInt(2);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public Object[] select (int id) throws UndefindedIndexException{
        Object[] result = new Object[2];
        try{
            ResultSet resultSet = dayLogicInterface.select(id, connection);
            if (resultSet.next()){
                result[0] = resultSet.getInt(1);
                result[1] = resultSet.getInt(2);
            } else throw new UndefindedIndexException("Day", id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public void update (int id, Object[] list){
        try{
            dayLogicInterface.update(id, list, connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
