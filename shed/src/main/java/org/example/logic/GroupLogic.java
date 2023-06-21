package org.example.logic;

import org.example.data.GroupDAO;
import org.example.data.TableDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class GroupLogic implements TableLogic{

    private Connection connection;
    private TableDAO groupLogicInterface;

    public GroupLogic(Connection init_connection){
        connection = init_connection;
        groupLogicInterface = new GroupDAO();
    }
    public void insert (Object[] list){
        try {
            groupLogicInterface.insert(list, connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete (int id){
        try{
            groupLogicInterface.delete(id, connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Vector<Object[]> select (){
        Vector<Object[]> result = new Vector<Object[]>();
        try{
            ResultSet resultSet = groupLogicInterface.select(connection);
            for (int i = 0; resultSet.next(); i++){
                result.add(new Object[3]);
                result.elementAt(i)[0] = resultSet.getInt(1);
                result.elementAt(i)[1] = resultSet.getString(2);
                result.elementAt(i)[2] = resultSet.getInt(3);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public Object[] select (int id) throws UndefindedIndexException{
        Object[] result = new Object[3];
        try{
            ResultSet resultSet = groupLogicInterface.select(id, connection);
            if (resultSet.next()){
                result[0] = resultSet.getInt(1);
                result[1] = resultSet.getString(2);
                result[2] = resultSet.getInt(3);
            } else throw new UndefindedIndexException("Group", id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public void update (int id, Object[] list){
        try{
            groupLogicInterface.update(id, list, connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
