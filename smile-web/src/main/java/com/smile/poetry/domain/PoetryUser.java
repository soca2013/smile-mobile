package com.smile.poetry.domain;

import java.util.Date;

public class PoetryUser {

    private Long id;

    private String name;

    private int readDays;

    private int level;

    private Date expirationDate;

    private int rank;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReadDays() {
        return readDays;
    }

    public void setReadDays(int readDays) {
        this.readDays = readDays;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
