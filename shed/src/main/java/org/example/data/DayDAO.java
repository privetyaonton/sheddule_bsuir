package org.example.data;

import java.sql.*;

public class DayDAO implements TableDAO {
    public void insert (Object[] list, Connection connection) throws SQLException {
        int code_day = (int) list[0];

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO day (code) VALUES (?);"
        );
        preparedStatement.setInt(1, code_day);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public void delete (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM day WHERE id_day = ?;"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public ResultSet select (Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM day;");
        statement.close();
        return resultSet;
    }
    public ResultSet select (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM day WHERE id_day = ?;"
        );
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.close();
        return resultSet;
    }
    public void update (int id, Object[] list, Connection connection) throws SQLException{
        int code_day = (int) list[0];
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE day SET code = ? WHERE id_day = ?;"
        );
        preparedStatement.setInt(1, code_day);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
