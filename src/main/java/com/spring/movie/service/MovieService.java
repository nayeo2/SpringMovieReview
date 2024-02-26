package com.spring.movie.service;

import java.util.List;
import com.spring.movie.entity.Movie;

public interface MovieService {
    List<Movie> findAll();

    // 단일 포스팅을 조회하는 메서드 findById()를 선언하고 1:1로 보내주세요
    Movie findById(long userId);

    // 단일 포스팅을 삭제하는 메서드 deleteById()를 선언하고 1:1로 보내주세요
    void deleteById(long userId);

    // 단일 포스팅을 게시하는 메서드 save()를 선언하고 1:1로 보내주세요.
    void save(Movie movie);

    // 특정 포스팅을 수정하는 메서드 update()
    void update(Movie movie);

}
