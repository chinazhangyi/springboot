package cn.jxufe.service;

import cn.jxufe.entity.Memberinfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/8/7.
 */
public interface MemberInfoService {
    public Memberinfo login(String memberMobile, String memberPasswd);
    public int register(String memberMobile);
    public Memberinfo ifregister(String memberMobile);
    public  int changepwd(Memberinfo memberinfo);
    public int changeName(Memberinfo memberinfo);
    public Memberinfo getMemberName(int memberid);
    public int changePhone(Memberinfo memberinfo);
    //刘
    Memberinfo findByMemberId( int memberId);
}
