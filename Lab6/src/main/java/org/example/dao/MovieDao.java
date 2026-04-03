package org.example.dao;

import org.example.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDao {
    public void create(String title, String releaseDate, int duration, double score, int genreId) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO movies (title, release_date, duration, score, genre_id) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, title);
            pstmt.setString(2, releaseDate);
            pstmt.setInt(3, duration);
            pstmt.setDouble(4, score);
            pstmt.setInt(5, genreId);
            pstmt.executeUpdate();
        }
    }

    public List<Map<String, Object>> getMovieReportData() throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        List<Map<String, Object>> reportData = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM movie_report");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("title", rs.getString("title"));
                row.put("release_date", rs.getString("release_date"));
                row.put("score", rs.getDouble("score"));
                row.put("genre", rs.getString("genre"));
                reportData.add(row);
            }
        }
        return reportData;
    }
}
