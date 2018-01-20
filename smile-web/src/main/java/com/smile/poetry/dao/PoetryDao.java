package com.smile.poetry.dao;


import com.smile.poetry.domain.Poetry;
import com.smile.poetry.domain.PoetryUser;
import com.smile.poetry.domain.ReadPoetry;
import com.smile.sharding.page.Pagination;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhutao on 2017/4/19.
 */
@Mapper
public interface PoetryDao {


    @Select("select * from poetry where id = #{poetryId} ")
    Poetry findPoetryById(@Param("poetryId") Long poetryId);


    @Select("<script>" +
            "select p.* from poetry p ,poetry_collection c where c.poetry_id = p.id and c.user_id =#{userId}" +
            "</script>"
    )
    List<Poetry> findCollectionByUserId(@Param("userId") Long userId, @Param("page") Pagination<Poetry> pagination);


    @Select("<script>" +
            "select p.id,p.name,p.context,p.dynasty,p.author,r.read_date readDate,p.score,p.record" +
            " from poetry p ,poetry_record r where r.poetry_id = p.id and r.user_id =#{userId}" +
            "</script>"
    )
    List<ReadPoetry> findReadPoetryByUserId(@Param("userId") Long userId, @Param("page") Pagination<ReadPoetry> pagination);


    @Select("<script>" +
            "select f.*" +
            " from peotry_user u ,peotry_friend f where f.friend_id = u.id and f.user_id =#{userId}" +
            "</script>"
    )
    List<PoetryUser> rankingList(@Param("userId") Long userId, @Param("page") Pagination<PoetryUser> pagination);


    @Select("select * from poetry  ")
    List<Poetry> findAllPoetry(@Param("page") Pagination<Poetry> pagination);


    @Select("select * from peotry_user u , (select user_id,count(1) from poetry_collection where user_id =#{userId} ) tmp  where u.user_id =#{userId} and u.user_id= tmp.user_id")
    PoetryUser findPoetryUserById(@Param("userId") Long userId);


    @Insert("")
    void addPoetryUser(PoetryUser poetryUser);

    @Insert("peotry_vip")
    void addPoetryVip(Long userId, Integer rank);


}
