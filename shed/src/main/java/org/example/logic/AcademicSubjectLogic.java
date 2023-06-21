package org.example.logic;

import org.example.data.AcademicSubjectDAO;
import org.example.data.TableDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class AcademicSubjectLogic implements TableLogic{
    private Connection connection;
    private TableDAO academicSubjectLogicInterface;

    public AcademicSubjectLogic(Connection init_connection){
        connection = init_connection;
        academicSubjectLogicInterface = new AcademicSubjectDAO();
    }

    public void insert (Object[] list){

    }
    public void delete (int id){

    }
    public Vector<Object[]> select (){
        Vector<Object[]> result = new Vector<Object[]>();
        try{
            ResultSet resultSet = academicSubjectLogicInterface.select(connection);
            for (int i = 0; resultSet.next(); i++){
                result.add(new Object[2]);
                result.elementAt(i)[0] = resultSet.getInt(1);
                result.elementAt(i)[1] = resultSet.getString(2);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public Object[] select (int id) throws UndefindedIndexException{
        Object[] result = new Object[2];
        try{
            ResultSet resultSet = academicSubjectLogicInterface.select(
                    id, connection);
            if (resultSet.next()){
                result[0] = resultSet.getInt(1);
                result[1] = resultSet.getString(2);
            } else throw new UndefindedIndexException("AcademicSubject", id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public void update (int id, Object[] list){

    }
}
