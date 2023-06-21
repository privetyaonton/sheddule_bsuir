package org.example.data;

import java.sql.*;

public class DayClassDAO implements TableDAO {
    public void insert (Object[] list, Connection connection) throws SQLException {
        int id_day = (int) list[0];
        int id_class = (int)list[1];

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO dayclass (id_day, id_class) VALUES (?, ?);"
        );
        preparedStatement.setInt(1, id_day);
        preparedStatement.setInt(2, id_class);
        preparedStatement.executeUpdate();
    }
    public void delete (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM dayclass WHERE id_day_class = ?;"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    public ResultSet select (Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM dayclass;");
    }
    public ResultSet select (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM dayclass WHERE id_day_class = ?;"
        );
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }
    public void update (int id, Object[] list, Connection connection) throws SQLException{
        int id_day = (int) list[0];
        int id_class = (int)list[1];

        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE dayclass SET id_day = ?, id_class = ? WHERE id_day_class = ?;"
        );
        preparedStatement.setInt(1, id_day);
        preparedStatement.setInt(2, id_class);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
    }
}
