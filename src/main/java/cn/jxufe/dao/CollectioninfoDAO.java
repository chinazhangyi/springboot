package cn.jxufe.dao;

import cn.jxufe.entity.Collectioninfo;

import cn.jxufe.entity.Goodsinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CollectioninfoDAO继承基类
 */
@Repository
public interface CollectioninfoDAO extends MyBatisBaseDao<Collectioninfo, Integer> {
    List<Collectioninfo>  findAll(@Param("memberid") int memberid);
    int  addCollection(Collectioninfo collectioninfo);
    int  deleteColletion(Collectioninfo collectioninfo);
    Collectioninfo judgeCollection(Collectioninfo collectioninfo);
}