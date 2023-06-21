package org.example.logic;

import org.example.data.TableDAO;
import org.example.data.TeacherDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TeacherLogic implements TableLogic {
    private Connection connection;
    private TableDAO teacherLogicInterface;

    public TeacherLogic(Connection init_connection){
        connection = init_connection;
        teacherLogicInterface = new TeacherDAO();
    }

    public void insert (Object[] list){

    }
    public void delete (int id){

    }
    public Vector<Object[]> select (){
        Vector<Object[]> result = new Vector<Object[]>();
        try{
            ResultSet resultSet = teacherLogicInterface.select(connection);
            for (int i = 0; resultSet.next(); i++){
                result.add(new Object[5]);
                result.elementAt(i)[0] = resultSet.getInt(1);
                result.elementAt(i)[1] = resultSet.getString(2);
                result.elementAt(i)[2] = resultSet.getString(3);
                result.elementAt(i)[3] = resultSet.getString(4);
                result.elementAt(i)[4] = resultSet.getInt(5);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public Object[] select (int id) throws UndefindedIndexException{
        Object[] result = new Object[5];
        try{
            ResultSet resultSet = teacherLogicInterface.select(id, connection);
            if (resultSet.next()){
                result[0] = resultSet.getInt(1);
                result[1] = resultSet.getString(2);
                result[2] = resultSet.getString(3);
                result[3] = resultSet.getString(4);
                result[4] = resultSet.getInt(5);
            } else throw new UndefindedIndexException("Teacher", id);
        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
    public void update (int id, Object[] list){

    }
}
