package org.example.data;

import java.sql.*;

public class AcademicSubjectDAO implements TableDAO{
    public void insert (Object[] list, Connection connection) throws SQLException{

    }
    public void delete (int id, Connection connection) throws SQLException{

    }
    public ResultSet select (Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM academic_subject;");
        statement.close();
        return resultSet;
    }
    public ResultSet select (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM academic_subject " +
                        "WHERE id_academic_subject = ?;"
        );
        preparedStatement.setInt(1, id);
        ResultSet resultSet =  preparedStatement.executeQuery();
        preparedStatement.close();
        return resultSet;
    }
    public void update (int id, Object[] list, Connection connection) throws SQLException{

    }
}
