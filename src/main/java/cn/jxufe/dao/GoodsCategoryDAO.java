package cn.jxufe.dao;

import cn.jxufe.entity.GoodsCategory;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GoodsCategoryDAO继承基类
 */
@Repository
public interface GoodsCategoryDAO extends MyBatisBaseDao<GoodsCategory, Integer> {
    public List<GoodsCategory> findtype();

}