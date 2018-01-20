package com.smile.poetry.controller;

import com.smile.core.domain.Result;
import com.smile.core.exceptions.BussinessException;
import com.smile.poetry.domain.Poetry;
import com.smile.poetry.domain.PoetryUser;
import com.smile.poetry.service.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class PoetryUserController {

    @Autowired
    private PoetryService poetryService;

    @RequestMapping(value = "/getInfo", produces = "application/json")
    public Result<PoetryUser> getInfo(@RequestParam(value = "userId") Long userId) throws BussinessException {
        PoetryUser poetry = poetryService.findPoetryUserById(userId);
        Result<PoetryUser> result = new Result<PoetryUser>();
        result.setStatus(0);
        result.setData(poetry);
        return result;
    }

    @RequestMapping(value = "/upload", produces = "application/json")
    public Result<PoetryUser> upload(@RequestBody  PoetryUser poetryUser) throws BussinessException {
        poetryService.addPoetryUser(poetryUser);
        Result<PoetryUser> result = new Result<PoetryUser>();
        result.setStatus(0);
        return result;
    }


}
