package com.spring.movie.service;

import com.spring.movie.repository.MoiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 빈 컨테이너에 적재
public class MoiveServiceImpl implements MoiveService {

    MoiveRepository moiveRepository;


    @Autowired // 생성자 주입이 속도가 더 빠름.
    public MoiveServiceImpl(MoiveRepository moiveRepository){
        this.moiveRepository = moiveRepository;
    }

    @Override
    public List<Moive> findAll() {
        //List<Blog> blogList = blogRepository.findAll();
        //return blogList;
        return moiveRepository.findAll();
    }

    @Override
    public Moive findById(long userId) {
        return moiveRepository.findById(userId);
    }

    @Transactional // 둘다 실행되던지 둘 다 실행 안되던지
    @Override
    public void deleteById(long userId) {
        moiveRepository.deleteById(userId);
    }

    @Override
    public void save(Moive moive) {
        moiveRepository.save(moive);
    }

    @Override
    public void update(Moive moive) {
        moiveRepository.update(moive);
    }

}
