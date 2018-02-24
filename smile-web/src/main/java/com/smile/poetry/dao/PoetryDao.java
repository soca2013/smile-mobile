package com.smile.poetry.dao;


import com.smile.poetry.domain.Poetry;
import com.smile.poetry.domain.PoetryCollection;
import com.smile.poetry.domain.PoetryUser;
import com.smile.poetry.domain.ReadPoetry;
import com.smile.sharding.page.Pagination;
import org.apache.ibatis.annotations.*;

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
            "select * from poetry_collection c where c.poetry_id = #{poetryId} and c.user_id =#{userId}" +
            "</script>"
    )
    PoetryCollection findCollectionByUserIdAndPoetryId(@Param("userId") Long userId, @Param("poetryId") Long poetryId);

    @Select("select p.* from poetry p ,poetry_record r where r.user_id = #{userId} and r.read_date=to_days(now()) and p.id = r.poetry_id")
    Poetry findPoetryForHome(@Param("userId") Long userId);



    @Select("<script>" +
            "select p.id,p.name,p.context,p.dynasty,p.author,r.read_date readDate,p.score,p.record" +
            " from poetry p ,poetry_record r where r.poetry_id = p.id and r.user_id =#{userId}" +
            "</script>"
    )
    List<ReadPoetry> findReadPoetryByUserId(@Param("userId") Long userId, @Param("page") Pagination<ReadPoetry> pagination);

    @Select("<script>" +
            "select p.id,p.name,p.context,p.dynasty,p.author,r.read_date readDate,p.score,p.record" +
            " from poetry_record r where r.poetry_id = #{poetryId} and r.user_id =#{userId} order by read_date desc limit 1" +
            "</script>"
    )
    ReadPoetry findReadPoetryByUserIdAndPoetryId(@Param("userId") Long userId, @Param("poetryId") Long poetryId);


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


    @Insert("insert into peotry_user(name,read_days,level,expiration_date) values (#{name},#{read_days},#{readDays},#{level},#{expirationDate})")
    void addPoetryUser(PoetryUser poetryUser);

    @Update("update table peotry_user set name=#{name},read_days=#{readDays},level=#{level},expiration_date=#{expirationDate} where id =#{id} ")
    void updatePoetryUser(PoetryUser poetryUser);

    @Insert("peotry_vip")
    void addPoetryVip(Long userId, Integer rank);


    @Insert("select * from poetry_record where id = #{poetryId} and read_date=now() ")
    Poetry addReadPoetry(ReadPoetry readPoetry);

    @Insert("insert into poetry_collection(user_id,peotry_id,status) values (#{userId},#{peotryId},#{status}) duplicate key update status= #{status}")
    Poetry addPoetryCollection(PoetryCollection  poetryCollection);

}
