package com.smile.core.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.smile.core.domain.SysUser;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class LocalCache {



    private static LoadingCache<String, SysUser> localCache;

    static{
        localCache = CacheBuilder.newBuilder().maximumSize(100000).build(
                new CacheLoader<String, SysUser>() {
                    public @Override
                    SysUser load(String key) {
                        return null;
                    }
                    public @Override
                    ListenableFuture<SysUser> reload(final String key, SysUser prevGraph) {
                        return null;
                    }

                }

        );
    }


    public static void set(String sid, SysUser sysUser) {
        localCache.put(sid, sysUser);
    }

    public static SysUser get(String sid) throws ExecutionException {
        return localCache.getIfPresent(sid);
    }

    public static void remove(String sid) {
        localCache.put(sid, null);
    }


}
