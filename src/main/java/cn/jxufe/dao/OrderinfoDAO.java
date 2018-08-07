package cn.jxufe.dao;

import cn.jxufe.entity.Orderinfo;

import org.springframework.stereotype.Repository;

/**
 * OrderinfoDAO继承基类
 */
@Repository
public interface OrderinfoDAO extends MyBatisBaseDao<Orderinfo, Integer> {
}