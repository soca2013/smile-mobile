package com.smile.core.service;

import com.smile.core.dao.SysUserDao;
import com.smile.core.domain.SysUser;
import com.smile.sharding.page.Pagination;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhutao on 2016/7/16.
 */
@Service
public class SysUserService {

    private final static String DEFAULT_PASSWORD = "123";

    @Autowired
    private SysUserDao userDao;

    public List<SysUser> selectList(SysUser user, Pagination<SysUser> pagination) {
        return userDao.selectList(user, pagination);
    }

    public SysUser selectById(long userId) {
        return userDao.selectById(userId);
    }

    public SysUser selectByUserNameForPassword(@Param("loginName") String loginName) {
        return userDao.selectByUserNameForPassword(loginName);
    }

}
