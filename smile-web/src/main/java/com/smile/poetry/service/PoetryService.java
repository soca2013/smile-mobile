package com.smile.poetry.service;

import com.smile.poetry.dao.PoetryDao;
import com.smile.poetry.domain.Poetry;
import com.smile.poetry.domain.PoetryUser;
import com.smile.poetry.domain.ReadPoetry;
import com.smile.sharding.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhutao on 2017/4/23.
 */
@Service
public class PoetryService {

    @Autowired
    private PoetryDao poetryDao;


    public Poetry findPoetryById(Long poetryId) {
        if (poetryId != null) {
            return poetryDao.findPoetryById(poetryId);
        } else {
            return poetryDao.findPoetryById(poetryId);
        }
    }

    public List<Poetry> findCollectionByUserId(Long userId, Pagination<Poetry> pagination) {
        return poetryDao.findCollectionByUserId(userId, pagination);
    }

    public List<ReadPoetry> findReadPoetryByUserId(Long userId, Pagination<ReadPoetry> pagination) {
        return poetryDao.findReadPoetryByUserId(userId, pagination);
    }


    public List<Poetry> findAllPoetry(Pagination<Poetry> pagination) {
        return poetryDao.findAllPoetry(pagination);
    }

    public List<PoetryUser> rankingList(Long userId, Pagination<PoetryUser> pagination) {
        return poetryDao.rankingList(userId, pagination);
    }


    public PoetryUser findPoetryUserById(Long userId) {
        return poetryDao.findPoetryUserById(userId);
    }

    public void addPoetryUser(PoetryUser poetryUser) {
        poetryDao.addPoetryUser(poetryUser);
    }


    public void addPoetryVip(Long userId,Integer rank) {
        poetryDao.addPoetryVip(userId,rank);
    }


}
