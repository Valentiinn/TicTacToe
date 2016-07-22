package com.karayvansky.game;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DataBase {
    private Connection connection;

    public boolean isConnect() throws IOException, SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tictactoe?serverTimezone=UTC&useSSL=false", "root", "123456");
        return true;
    }

    public void printStudents(Connection connection) throws SQLException {
    }

    public void addStatistics(GameResult result) throws SQLException {
        String sql = "insert into statistics (firstname, lastname, result, date) values (?, ?, ?, ?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, result.getPlayer().getFirstName());
        preparedStatement.setString(2, result.getPlayer().getLastName());
        preparedStatement.setString(3, result.getResult());
        preparedStatement.setString(4, result.getDate().toString());

        preparedStatement.execute();
    }
}
