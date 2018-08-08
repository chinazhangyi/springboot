package cn.jxufe.dao;

import cn.jxufe.entity.Memberinfo;

import org.jboss.logging.Param;
import org.springframework.stereotype.Repository;

/**
 * MemberinfoDAO继承基类
 */
@Repository
public interface MemberinfoDAO extends MyBatisBaseDao<Memberinfo, Integer> {

}