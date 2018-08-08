package cn.jxufe.dao;

import cn.jxufe.entity.Goodsinfo;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GoodsinfoDAO继承基类
 */
@Repository
public interface GoodsinfoDAO extends MyBatisBaseDao<Goodsinfo, Integer> {
    /**
     *
     * @return
     */
    public List<Goodsinfo> findAllGoods();


}