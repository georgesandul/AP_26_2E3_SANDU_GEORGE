package com.example.Lab7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class MovieController {

    @GetMapping("/movies")
    public List<Map<String, Object>> getMovies() {
        try {
            MovieDao movieDao = new MovieDao();
            return movieDao.getMovieReportData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}