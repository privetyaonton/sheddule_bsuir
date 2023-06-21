package org.example.data;

import java.sql.*;

public class TeacherDAO implements TableDAO{

    public void insert (Object[] list, Connection connection) throws SQLException{

    }
    public void delete (int id, Connection connection) throws SQLException{
    }
    public ResultSet select (Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM teacher;");
    }
    public ResultSet select (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM teacher WHERE id_teacher = ?;"
        );
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }
    public void update (int id, Object[] list, Connection connection) throws SQLException{
    }
}
