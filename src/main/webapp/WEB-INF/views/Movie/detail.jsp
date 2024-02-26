<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        div {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row first-row">
        <div class="col-1">
            번호
        </div>
        <div class="col-1">
            ${movie.userId}
        </div>
        <div class="col-2">
            영화제목
        </div>
        <div class="col-4">
            ${movie.movieTitle}
        </div>
        <div class="col-1">
            작성자
        </div>
        <div class="col-1">
            ${movie.uname}
        </div>
        <div class="col-1">
            조회수
        </div>
        <div class="col-1">
            ${movie.movieCount}
        </div>
    </div><!--.first-row-->
    <div class="row second-row">
        <div class="col-1">
            작성일
        </div>
        <div class="col-5">
            ${movie.publishedAt}
        </div>
        <div class="col-1">
            수정일
        </div>
        <div class="col-5">
            ${movie.updatedAt}
        </div>
    </div><!-- .row second -->
    <div class="row third-row">
        <div class="col-1">
            본문
        </div>
        <div class="col-11">
            ${movie.movieContent}
        </div>
    </div><!-- .row third -->
    <div class="row fourth-row">
        <div class="col-2">
            <a href="/movie/list"><button class="btn btn-secondary">목록으로</button></a>
        </div>
        <div class="col-2">
            <form action="/movie/delete" method="POST">
                <input type="hidden" name="userId" value="${movie.userId}">
                <input type="submit" value="삭제하기" class="btn btn-warning">
            </form>
        </div>
        <div class="col-2">
            <form action="/movie/updateform" method="POST">
                <input type="hidden" name="userId" value="${movie.movieId}">
                <input type="submit" value="수정하기" class="btn btn-info">
            </form>
        </div>
    </div><!-- .row fourth -->
</div><!-- .container -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
