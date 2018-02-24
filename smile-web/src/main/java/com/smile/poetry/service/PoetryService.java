package com.smile.poetry.service;

import com.smile.poetry.dao.PoetryDao;
import com.smile.poetry.domain.Poetry;
import com.smile.poetry.domain.PoetryCollection;
import com.smile.poetry.domain.PoetryUser;
import com.smile.poetry.domain.ReadPoetry;
import com.smile.poetry.dto.PoetryHomeDTO;
import com.smile.sharding.page.Pagination;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by zhutao on 2017/4/23.
 */
@Service
public class PoetryService {

    @Autowired
    private PoetryDao poetryDao;


    public PoetryHomeDTO findPoetryById(Long userId, Long poetryId) throws InvocationTargetException, IllegalAccessException {
        PoetryHomeDTO poetryHomeDTO = new PoetryHomeDTO();
        Poetry poetry = null;
        if (poetryId != null) {
            poetry = poetryDao.findPoetryById(poetryId);
        } else {
            poetry = poetryDao.findPoetryForHome(userId);
        }
        BeanUtils.copyProperties(poetryHomeDTO, poetry);

        PoetryCollection poetryCollection = poetryDao.findCollectionByUserIdAndPoetryId(userId, poetry.getId());
        if (poetryCollection != null) {
            poetryHomeDTO.setIsColleciont(1);
        } else {
            poetryHomeDTO.setIsColleciont(0);
        }
        ReadPoetry readPoetry = poetryDao.findReadPoetryByUserIdAndPoetryId(userId, poetry.getId());
        if (readPoetry == null) {
            poetryHomeDTO.setStar(-1);
        } else {
            poetryHomeDTO.setStar(readPoetry.getScore());
        }
        return poetryHomeDTO;
    }

    public List<Poetry> findCollectionByUserId(Long userId, Pagination<Poetry> pagination) {
        return poetryDao.findCollectionByUserId(userId, pagination);
    }

    public void addPoetryCollection(PoetryCollection collection) {
         poetryDao.addPoetryCollection(collection);
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

    public void updatePoetryUserForRank(PoetryUser poetryUser) {
        PoetryUser older=  poetryDao.findPoetryUserById(poetryUser.getId());
        older.setRank(poetryUser.getRank());
        poetryDao.updatePoetryUser(poetryUser);
    }


    public void addPoetryVip(Long userId, Integer rank) {
        poetryDao.addPoetryVip(userId, rank);
    }


}
