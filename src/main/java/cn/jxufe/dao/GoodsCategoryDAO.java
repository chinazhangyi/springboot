package cn.jxufe.dao;

import cn.jxufe.entity.GoodsCategory;

import org.springframework.stereotype.Repository;

/**
 * GoodsCategoryDAO继承基类
 */
@Repository
public interface GoodsCategoryDAO extends MyBatisBaseDao<GoodsCategory, Integer> {
}