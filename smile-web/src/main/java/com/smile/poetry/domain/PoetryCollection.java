package com.smile.poetry.domain;

import org.apache.ibatis.annotations.Param;

public class PoetryCollection {

    private Long userId;
    private Long poetryId;
    private int status;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPoetryId() {
        return poetryId;
    }

    public void setPoetryId(Long poetryId) {
        this.poetryId = poetryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
