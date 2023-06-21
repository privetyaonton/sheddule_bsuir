package org.example.logic;
import org.example.data.ClassDAO;
import org.example.data.TableDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ClassLogic implements TableLogic{
    public ClassLogic (Connection init_connection) {
        connection = init_connection;
        classLogicInterface = new ClassDAO();
    }
    private Connection connection;
    private TableDAO classLogicInterface;

    public void insert (Object[] list){
        try {
           classLogicInterface.insert(list, connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete (int id){
        try {
            classLogicInterface.delete(id, connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Vector<Object[]> select (){
        Vector<Object[]> result = new Vector<Object[]>();
        try {
            ResultSet resultSet = classLogicInterface.select(connection);
            for (int i = 0; resultSet.next(); i++) {
                result.add(new Object[7]);
                result.elementAt(i)[0] = resultSet.getInt(1);
                result.elementAt(i)[1] = resultSet.getInt(2);
                result.elementAt(i)[2] = resultSet.getInt(3);
                result.elementAt(i)[3] = resultSet.getInt(4);
                result.elementAt(i)[4] = resultSet.getString(5);
                result.elementAt(i)[5] = resultSet.getString(6);
                result.elementAt(i)[6] = resultSet.getString(7);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public Object[] select (int id) throws UndefindedIndexException{
        Object[] result = new Object[7];
        try{
            ResultSet resultSet = classLogicInterface.select(id, connection);
            if (resultSet.next()){
                result[0] = resultSet.getInt(1);
                result[1] = resultSet.getInt(2);
                result[2] = resultSet.getInt(3);
                result[3] = resultSet.getInt(4);
                result[4] = resultSet.getString(5);
                result[5] = resultSet.getString(6);
                result[6] = resultSet.getString(7);
            } else throw new UndefindedIndexException("Classes", id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public void update (int id, Object[] list){
        try {
            classLogicInterface.update(id, list, connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
