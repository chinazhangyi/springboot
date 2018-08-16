package cn.jxufe.dao;

import cn.jxufe.entity.Memberinfo;
import cn.jxufe.entity.Searchinfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SearchinfoDAO继承基类
 */
@Repository
public interface SearchinfoDAO extends MyBatisBaseDao<Searchinfo, Integer> {
    public Searchinfo addSerachHis();
    public String deleteSearchHis();//陈
    public List<Searchinfo> findUsersHis(Integer memberId);

    //刘
    public int addSearchinfo(Searchinfo searchinfo);
    public List<Searchinfo> findById(@Param("memberId") int memberId);
    public int deleteSearchinfoBymemberId(@Param("memberId") int memberId);
    Searchinfo findNewSearchinfo();

}