package cn.jxufe.dao;

import cn.jxufe.entity.Collectioninfo;

import org.springframework.stereotype.Repository;

/**
 * CollectioninfoDAO继承基类
 */
@Repository
public interface CollectioninfoDAO extends MyBatisBaseDao<Collectioninfo, Integer> {
}