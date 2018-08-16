package cn.jxufe.service.impl;

import cn.jxufe.dao.MemberinfoDAO;
import cn.jxufe.entity.Memberinfo;
import cn.jxufe.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/8/7.
 */
@Service
public class MemberInfoServiceImpl implements MemberInfoService {
    @Autowired
    private MemberinfoDAO memberinfoDAO;
    @Override
    public Memberinfo login(String memberMobile, String memberPasswd) {
        return memberinfoDAO.login(memberMobile,memberPasswd);
    }

    @Override
    public int register(String memberMobile) {
        return memberinfoDAO.register(memberMobile);
    }

    @Override
    public Memberinfo ifregister(String memberMobile) {
        return memberinfoDAO.ifregister(memberMobile);
    }

    @Override
    public Memberinfo findByMemberId(int memberId) {
        return memberinfoDAO.findByMemberId(memberId);
    }

    @Override
    public int changepwd(Memberinfo memberinfo) {
        return memberinfoDAO.changepwd(memberinfo);
    }

    @Override
    public int changeName(Memberinfo memberinfo) {
        return memberinfoDAO.changeName(memberinfo);
    }

    @Override
    public Memberinfo getMemberName(int memberid) {
        return memberinfoDAO.getMemberName(memberid);
    }

    @Override
    public int changePhone(Memberinfo memberinfo) {
        return memberinfoDAO.changePhone(memberinfo);
    }
}
