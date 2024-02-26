package com.spring.movie.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    private long userId;
    private String uname;
    private String movieTitle;
    private String movieContent;
    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;
    private String watchedAt; // 날짜를 문자열로 저장

    // watchedAt 문자열을 LocalDateTime으로 변환하여 반환하는 메서드
    public LocalDateTime getWatchedAtAsLocalDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDateTime.parse(watchedAt, formatter);
    }

    // watchedAt을 문자열로 설정하는 메서드
    public void setWatchedAtFromString(String watchedAt) {
        this.watchedAt = watchedAt;
    }
}
