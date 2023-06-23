package org.example.data;
import java.sql.*;

public interface TableDAO {
    public void insert (Object[] list, Connection connection) throws SQLException;
    public void delete (int id, Connection connection) throws SQLException;
    public ResultSet select (Connection connection) throws SQLException;
    public ResultSet select (int id, Connection connection) throws SQLException;
    public void update (int id, Object[] list, Connection connection) throws SQLException;
}
