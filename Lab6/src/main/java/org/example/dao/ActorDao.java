package org.example.dao;

import org.example.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActorDao {
    public void create(String name) throws SQLException {
        Connection con = DatabaseConnection.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO actors (name) VALUES (?)")){
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
}
