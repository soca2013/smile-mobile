package com.smile.poetry.controller;

import com.smile.core.domain.Result;
import com.smile.core.exceptions.BussinessException;
import com.smile.poetry.domain.Poetry;
import com.smile.poetry.service.PoetryService;
import com.smile.sharding.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhutao on 2017/4/23.
 */
@RestController
@RequestMapping("/collection")
public class PoetryCollectionController {


    @Autowired
    private PoetryService poetryService;


    @RequestMapping(value = "/getInfo", produces = "application/json")
    public Result<List<Poetry>> collection( @RequestParam(value = "userId") Long userId, Pagination<Poetry> pagination) {
        poetryService.findCollectionByUserId(userId,pagination);
        Result<List<Poetry>> result = new Result<List<Poetry>>();
        result.setStatus(0);
        result.setData(pagination.getRows());
        return result;
    }







}
