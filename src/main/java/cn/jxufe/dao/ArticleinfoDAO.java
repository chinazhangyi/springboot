package cn.jxufe.dao;

import cn.jxufe.entity.Articleinfo;
import org.springframework.stereotype.Repository;

/**
 * ArticleinfoDAO继承基类
 */
@Repository
public interface ArticleinfoDAO extends MyBatisBaseDao<Articleinfo, Integer> {
}