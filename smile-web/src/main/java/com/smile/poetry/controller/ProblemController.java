package com.smile.poetry.controller;

import com.smile.core.domain.Result;
import com.smile.poetry.domain.Poetry;
import com.smile.poetry.domain.PoetryCollection;
import com.smile.poetry.service.ProblemService;
import com.smile.sharding.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = "/getInfo", produces = "application/json")
    public Result<List<Poetry>> getInfo(@RequestParam(value = "userId") Long userId,@RequestParam(value = "poetryId") Long poetryId) {
//        problemService.findCollectionByUserId(userId, pagination);
        Result<List<Poetry>> result = new Result<List<Poetry>>();
//        result.setStatus(0);
//        result.setData(pagination.getRows());
        return result;
    }


    @RequestMapping(value = "/result", produces = "application/json")
    public Result result(@RequestBody PoetryCollection collection) {
//        poetryService.addPoetryCollection(collection);
        Result<List<Poetry>> result = new Result<List<Poetry>>();
//        result.setStatus(0);
        return result;
    }

}
