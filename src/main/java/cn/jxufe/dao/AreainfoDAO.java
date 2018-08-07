package cn.jxufe.dao;

import cn.jxufe.entity.Areainfo;

import org.springframework.stereotype.Repository;

/**
 * AreainfoDAO继承基类
 */
@Repository
public interface AreainfoDAO extends MyBatisBaseDao<Areainfo, Integer> {
}