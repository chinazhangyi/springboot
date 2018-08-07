package cn.jxufe.dao;

import cn.jxufe.entity.Searchinfo;

import org.springframework.stereotype.Repository;

/**
 * SearchinfoDAO继承基类
 */
@Repository
public interface SearchinfoDAO extends MyBatisBaseDao<Searchinfo, Integer> {
}