package com.spring.movie.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resttest")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RESTApiController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies/titles")
    public List<String> getAllMovieTitles() {
        List<Movie> movies = movieService.findAll();
        List<String> titles = new ArrayList<>();
        for (Movie movie : movies) {
            titles.add(movie.getTitle());
        }
        return titles;
    }
}}