package cn.jxufe.dao;

import cn.jxufe.entity.OrderinfoGoods;

import org.springframework.stereotype.Repository;

/**
 * OrderinfoGoodsDAO继承基类
 */
@Repository
public interface OrderinfoGoodsDAO extends MyBatisBaseDao<OrderinfoGoods, OrderinfoGoods> {
}