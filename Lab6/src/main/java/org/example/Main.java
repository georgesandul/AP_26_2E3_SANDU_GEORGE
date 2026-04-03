package org.example;

import org.example.dao.GenreDao;
import org.example.dao.MovieDao;
import org.example.dao.ActorDao;
import org.example.database.DatabaseConnection;

import javax.xml.crypto.Data;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            initDatabase();
            GenreDao genres = new GenreDao();
            MovieDao movies = new MovieDao();
            ActorDao actors = new ActorDao();

            try{
                genres.create("Action");
            } catch (Exception e) {}

            try{
                genres.create("SF");
            } catch (Exception e) {}

            try{
                movies.create("Interstellar", "2014", 150, 8.5, 2);
            } catch (Exception e) {}

            Integer actionId = genres.findByName("SF");
            System.out.println("sf id: " + actionId);

            org.example.report.ReportGenerator report = new org.example.report.ReportGenerator();
            report.generate();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
    }

    private static void initDatabase() throws Exception{
        Connection con = DatabaseConnection.getConnection();

        String sqlScript = new String(Files.readAllBytes(Paths.get("setup.sql")));

        try (Statement stmt = con.createStatement()){
            String[] commands = sqlScript.split(";");
            for(String command : commands){
                if(!command.trim().isEmpty()){
                    stmt.execute(command);
                }
            }
            System.out.println("tables initialized");
        }
    }

}
