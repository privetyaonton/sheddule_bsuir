package org.example.data;

import java.sql.*;

public class ClassDAO implements TableDAO {
    public void insert (Object[] list, Connection connection) throws SQLException{
        int id_group = (int) list[0];
        int id_teacher = (int) list[1];
        int id_academic_subject = (int) list[2];
        String auditory = (String) list[3];
        String time_start = (String) list[4];
        String time_end = (String) list[5];

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO classes (id_group, id_teacher, " +
                        "id_academic_subject, auditory, time_start, time_end) " +
                        "VALUES (?, ?, ?, ?, ?, ?);"
        );
        preparedStatement.setInt(1, id_group);
        preparedStatement.setInt(2, id_teacher);
        preparedStatement.setInt(3, id_academic_subject);
        preparedStatement.setString(4, auditory);
        preparedStatement.setString(5, time_start);
        preparedStatement.setString(6, time_end);
        preparedStatement.executeUpdate();
    }
    public void delete (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM classes WHERE id_class = ?;"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    public ResultSet select (Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        return statement.executeQuery("SELECT * FROM classes;");
    }
    public ResultSet select (int id, Connection connection) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM classes WHERE id_class = ?;"
        );
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }
    public void update(int id, Object[] list, Connection connection) throws SQLException{
        int id_group = (int) list[0];
        int id_teacher = (int) list[1];
        int id_academic_subject = (int) list[2];
        String auditory = (String) list[3];
        String time_start = (String) list[4];
        String time_end = (String) list[5];

        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE classes SET id_group = ?, id_teacher = ?, " +
                        "id_academic_subject = ?, auditory = ?, time_start = ?, " +
                        "time_end = ? WHERE id_class = ?;"
        );
        preparedStatement.setInt(1, id_group);
        preparedStatement.setInt(2, id_teacher);
        preparedStatement.setInt(3, id_academic_subject);
        preparedStatement.setString(4, auditory);
        preparedStatement.setString(5, time_start);
        preparedStatement.setString(6, time_end);
        preparedStatement.setInt(7, id);
        preparedStatement.executeUpdate();
    }
}
