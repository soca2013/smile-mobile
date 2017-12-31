package com.smile.core.utils;

import com.smile.core.domain.SysUser;


/**
 * Created by zhutao on 2016/8/13.
 */
public class UserHolder {

    private static final ThreadLocal<SysUser> local = new InheritableThreadLocal<SysUser>();



    public static void setSysUser(SysUser sysUser) {
        local.set(sysUser);
    }


    public static SysUser getMobileCurrentUser(SysUser sysUser) {
        return local.get();
    }


}
