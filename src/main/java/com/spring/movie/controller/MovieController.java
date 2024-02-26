package com.spring.movie.controller;

import com.spring.movie.entity.Moive;
import com.spring.movie.exception.NotFoundMoiveIdException;
import com.spring.movie.service.MoiveService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
@Log4j2
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @RequestMapping("/movie/list")
    public String list(Model model){
        List<Movie> movieList = movieService.findAll();
        model.addAttribute("movieList", movieList);
        return "movie/list";
    }

    @RequestMapping("/movie/detail/{userId}") // 여기서 수정
    public String detail(@PathVariable long userId, Model model){ // 여기서 수정
        Movie movie = movieService.findByUserId(userId); // 여기서 수정

        if(movie == null){
            try {
                throw new NotFoundMovieIdException("없는 userId로 조회했습니다. 조회번호 : " + userId); // 여기서 수정
            } catch(NotFoundMovieIdException e) {
                log.error("없는 userId로 조회했습니다. 조회번호 : " + userId); // 여기서 수정
                e.printStackTrace();
                return "movie/NotFoundMovieIdExceptionResultPage";
            }
        }
        model.addAttribute("movie", movie);
        return "movie/detail";
    }

    @RequestMapping(value = "/movie/insert", method= RequestMethod.GET)
    public String insert(){
        return "movie/movie-form";
    }

    @RequestMapping(value = "/movie/insert", method= RequestMethod.POST)
    public String insert(Movie movie){
        movieService.save(movie);
        return "redirect:/movie/list";
    }

    @RequestMapping(value = "/movie/delete", method= RequestMethod.POST)
    public String delete(long userId){ // 여기서 수정
        movieService.deleteByUserId(userId); // 여기서 수정
        return "redirect:/movie/list";
    }

    @RequestMapping(value="/movie/updateform", method = RequestMethod.POST)
    public String update(long userId, Model model){ // 여기서 수정
        Movie movie = movieService.findByUserId(userId); // 여기서 수정
        model.addAttribute("movie", movie);
        return "movie/movie-update-form";
    }

    @RequestMapping(value="/movie/update", method=RequestMethod.POST)
    public String update(Movie movie){
        movieService.update(movie);
        return "redirect:/movie/detail/" + movie.getUserId(); // 여기서 수정
    }
}
