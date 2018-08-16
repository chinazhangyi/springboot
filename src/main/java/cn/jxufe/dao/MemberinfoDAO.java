package cn.jxufe.dao;

import cn.jxufe.entity.Memberinfo;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * MemberinfoDAO继承基类
 */
@Repository
public interface MemberinfoDAO extends MyBatisBaseDao<Memberinfo, Integer> {

    public Memberinfo login(@Param("memberMobile") String memberMobile, @Param("memberPasswd") String memberPasswd);//陈
    public int register(@Param("memberMobile") String memberMobile);//陈
    public Memberinfo ifregister(@Param("memberMobile") String memberMobile);//陈
    public int changepwd(Memberinfo memberinfo);//陈
    public int changeName(Memberinfo memberinfo);//陈
    public Memberinfo getMemberName(@Param("memberId")int memberId);//陈
    public int changePhone(Memberinfo memberinfo);//陈
    Memberinfo  findByMemberId(@Param("memberId") int memberId);//刘

}