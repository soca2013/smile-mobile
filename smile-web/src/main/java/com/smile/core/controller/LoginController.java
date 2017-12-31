package com.smile.core.controller;

import com.smile.core.cache.LocalCache;
import com.smile.core.domain.*;
import com.smile.core.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Created by zhutao on 2016/7/16.
 */
@Controller()
@RequestMapping("/")
public class LoginController {

    private String algorithmName = "md5";
    private int hashIterations = 2;

    @Autowired
    private SysUserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<Map<String, String>> login(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password
    ) {
        Result<Map<String, String>> result = new Result<Map<String, String>>();
        if (StringUtils.isEmpty(username)) {
            result.setSuccess(false);
            result.setErrorMessage("please input username.");
        }

        if (StringUtils.isEmpty(password)) {
            result.setSuccess(false);
            result.setErrorMessage("please input password.");
        }
        SysUser sysUser = userService.selectByUserNameForPassword(username);
        if (sysUser != null && sysUser.getPassword().equals(hash(password, username + sysUser.getSalt()))) {
            result.setSuccess(true);
            Map<String, String> data = new HashMap<String, String>();
            result.setData(data);
            data.put("sid", UUID.randomUUID().toString());
            LocalCache.set(data.get("sid"), sysUser);
        } else if (sysUser == null) {
            result.setSuccess(false);
            result.setErrorMessage("user is not exist.");
        } else {
            result.setSuccess(false);
            result.setErrorMessage("user or password is error.");
        }
        return result;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Result<Map<String, String>> loginInfo(@RequestParam(value = "code", required = false) Integer code
    ) {
        Result<Map<String, String>> result = new Result<Map<String, String>>();
        if (code == 500) {
            result.setSuccess(false);
            result.setErrorMessage("user is not login.");
            return result;
        } else {
            result.setSuccess(false);
            result.setErrorMessage("please input username.");
        }
        return result;
    }


    @RequestMapping("/logout")
    @ResponseBody
    public Result<Map> logout(@Param("sid") String sid) {
        Result<Map> result = new Result<Map>();
        result.setSuccess(true);
        LocalCache.remove(sid);
        return result;
    }


    private String hash(String password, String salt) {
        return new SimpleHash(
                algorithmName,
                password.getBytes(),
                ByteSource.Util.bytes(salt),
                hashIterations).toHex();
    }


}
