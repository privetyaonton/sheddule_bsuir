package org.example.data;

import java.sql.*;

public class GroupDAO implements TableDAO{
    public void insert (Object[] list, Connection connection) throws SQLException{
        String numberGroup = (String) list[0];
        int id_speciallity = (int) list[2];

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO groups (number_group, id_speciallity)" +
                        "VALUES (?, ?);"
        );
        preparedStatement.setString(1, numberGroup);
        preparedStatement.setInt(2, id_speciallity);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public void delete (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM groups WHERE id_group = ?;"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public ResultSet select (Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM groups;");
        statement.close();
        return resultSet;
    }
    public ResultSet select (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM groups WHERE id_group = ?;"
        );
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        return resultSet;
    }
    public void update (int id, Object[] list, Connection connection) throws SQLException{
        String numberGroup = (String) list[0];
        int id_faculty = (int) list[1];
        int id_speciallity = (int) list[2];

        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE groups SET number_group = ?, " +
                        "id_speciallity = ? WHERE id_group = ?;"
        );
        preparedStatement.setString(1, numberGroup);
        preparedStatement.setInt(2, id_speciallity);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
