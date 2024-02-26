# 영화 테이블 생성 구문
CREATE TABLE movie(
                      user_id int auto_increment primary key,
                      uname varchar(16) not null,
                      movie_title varchar(200) not null,
                      review_content varchar(4000) not null,
                      published_at datetime default now(),
                      updated_at datetime default now(),
                      watched_at date not null
);

# 더미데이터 입력용 구문(테스트 DB에서만 사용합니다.)
INSERT INTO movie VALUES
    (null, '첫번째유저', '파묘', '생각보다 안 무섭당', now(), now(), STR_TO_DATE('20240226', '%Y%m%d')),
    (null, '2번유저', '2번제목', '2번본문', now(), now(), STR_TO_DATE('20240226', '%Y%m%d')),
    (null, '3번유저', '3번제목', '3번본문', now(), now(), STR_TO_DATE('20240226', '%Y%m%d'));
