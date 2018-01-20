package com.smile.poetry.controller;

import com.smile.core.domain.Result;
import com.smile.core.exceptions.BussinessException;
import com.smile.poetry.domain.PoetryUser;
import com.smile.poetry.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vip")
public class VipController {

    @Autowired
    private PoetryService poetryService;

    @RequestMapping(value = "/buy", produces = "application/json")
    public Result<PoetryUser> buy(@RequestParam(value = "userId") Long userId, @RequestParam(value = "rank") Integer rank) throws BussinessException {
        poetryService.addPoetryVip(userId, rank);
        Result<PoetryUser> result = new Result<PoetryUser>();
        result.setStatus(0);
        return result;
    }

}
