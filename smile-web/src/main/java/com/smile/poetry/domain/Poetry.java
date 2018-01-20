package com.smile.poetry.domain;

/**
 * 诗词
 * Created by zhutao on 2017/4/19.
 */
public class Poetry {

    /**
     * id
     */
    private long id;

    /**
     * 诗名称
     */
    private String name;

    /**
     * 诗内容
     */
    private String context;

    /**
     * 简介
     */
    private String introduce;

    /**
     * 注释
     */
    private String explain;

    /**
     * 译文
     */
    private String translation;

    /**
     * 赏析
     */
    private String appreciation;

    /**
     * 点评
     */
    private String review;

    /**
     * 朝代
     */
    private String  dynasty;

    /**
     * 作者
     */
    private String  author;

    /**
     * 背景图
     */
    private String backgroundImage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
