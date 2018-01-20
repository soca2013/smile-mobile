package com.smile.poetry.controller;

import com.smile.core.domain.Result;
import com.smile.core.exceptions.BussinessException;
import com.smile.poetry.domain.Poetry;
import com.smile.poetry.domain.ReadPoetry;
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
@RequestMapping("/poetry")
public class PoetryController {


    @Autowired
    private PoetryService poetryService;

    @RequestMapping(value = "/getInfo", produces = "application/json")
    public Result<Poetry> getInfo(@RequestParam(value = "userId", required = false) Long userId,@RequestParam(value = "poetryId", required = false) Long poetryId) throws BussinessException {
        Poetry poetry = poetryService.findPoetryById(poetryId);
        Result<Poetry> result = new Result<Poetry>();
        result.setStatus(0);
        result.setData(poetry);
        return result;
    }

    @RequestMapping(value = "/collection", produces = "application/json")
    public Result collection( @RequestParam(value = "userId") Long userId,@RequestParam(value = "poetryId", required = false) Long poetryId) {

        Result<List<Poetry>> result = new Result<List<Poetry>>();
        result.setStatus(0);
        return result;
    }


    @RequestMapping(value = "/history", produces = "application/json")
    public Result<List<ReadPoetry>> history(@RequestParam(value = "userId") Long userId, Pagination<ReadPoetry> pagination) {
        poetryService.findReadPoetryByUserId(userId,pagination);
        Result<List<ReadPoetry>> result = new Result<List<ReadPoetry>>();
        result.setStatus(0);
        result.setData(pagination.getRows());
        return result;
    }


    @RequestMapping(value = "/all", produces = "application/json")
    public Result<List<Poetry>> all(@RequestParam(value = "userId") Long userId, Pagination<Poetry> pagination) {
        poetryService.findAllPoetry(pagination);
        Result<List<Poetry>> result = new Result<List<Poetry>>();
        result.setStatus(0);
        result.setData(pagination.getRows());
        return result;
    }


    @RequestMapping(value = "/rankingList", produces = "application/json")
    public Result<List<Poetry>> rankingList(@RequestParam(value = "userId") Long userId, Pagination<Poetry> pagination) {
        poetryService.findAllPoetry(pagination);
        Result<List<Poetry>> result = new Result<List<Poetry>>();
        result.setStatus(0);
        result.setData(pagination.getRows());
        return result;
    }









}
