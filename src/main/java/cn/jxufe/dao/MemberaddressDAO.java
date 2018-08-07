package cn.jxufe.dao;

import cn.jxufe.entity.Memberaddress;

import org.springframework.stereotype.Repository;

/**
 * MemberaddressDAO继承基类
 */
@Repository
public interface MemberaddressDAO extends MyBatisBaseDao<Memberaddress, Integer> {
}