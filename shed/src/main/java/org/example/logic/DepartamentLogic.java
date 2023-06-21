package org.example.logic;

import org.example.data.DepartamentDAO;
import org.example.data.TableDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

public class DepartamentLogic implements TableLogic{
    private Connection connection;
    private TableDAO departamentLogicInterface;

    public DepartamentLogic(Connection init_connection){
        connection = init_connection;
        departamentLogicInterface = new DepartamentDAO();
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
            ResultSet resultSet = departamentLogicInterface.select(id, connection);
            if (resultSet.next()){
                result[0] = resultSet.getInt(1);
                result[1] = resultSet.getString(2);
                result[2] = resultSet.getInt(3);
            } else throw new UndefindedIndexException("Departaments", id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public void update (int id, Object[] list){

    }
}
