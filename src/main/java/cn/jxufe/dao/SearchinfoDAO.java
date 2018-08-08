package cn.jxufe.dao;

import cn.jxufe.entity.Memberinfo;
import cn.jxufe.entity.Searchinfo;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SearchinfoDAO继承基类
 */
@Repository
public interface SearchinfoDAO extends MyBatisBaseDao<Searchinfo, Integer> {
    public Searchinfo addSerachHis();
    public String deleteSearchHis();
    public List<Searchinfo> findUsersHis(Integer memberId);
}