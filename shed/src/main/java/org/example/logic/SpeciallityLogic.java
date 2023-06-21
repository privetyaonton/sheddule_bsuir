package org.example.logic;

import org.example.data.SpeciallityDAO;
import org.example.data.TableDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SpeciallityLogic implements TableLogic{
    private Connection connection;
    private TableDAO speciallityLogicInterface;

    public SpeciallityLogic(Connection init_connection){
        connection = init_connection;
        speciallityLogicInterface = new SpeciallityDAO();
    }
    public void insert (Object[] list){

    }
    public void delete (int id){

    }
    public Vector<Object[]> select (){
        return new Vector<Object[]>();
    }
    public Object[] select (int id) throws UndefindedIndexException{
        Object[] result = new Object[3];
        try{
            ResultSet resultSet = speciallityLogicInterface.select(id, connection);
            if (resultSet.next()){
                result[0] = resultSet.getInt(1);
                result[1] = resultSet.getInt(2);
                result[2] = resultSet.getString(3);
            } else throw new UndefindedIndexException("Speciallity", id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public void update (int id, Object[] list){

    }
}
