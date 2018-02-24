package com.smile.poetry.dto;

import com.smile.poetry.domain.Poetry;

public class PoetryHomeDTO extends Poetry {

    private Integer isColleciont;

    private Integer star;

    public Integer getIsColleciont() {
        return isColleciont;
    }

    public void setIsColleciont(Integer isColleciont) {
        this.isColleciont = isColleciont;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
