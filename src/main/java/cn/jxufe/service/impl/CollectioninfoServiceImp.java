package cn.jxufe.service.impl;

import cn.jxufe.dao.CollectioninfoDAO;
import cn.jxufe.dao.GoodsinfoDAO;
import cn.jxufe.entity.Collectioninfo;
import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.service.CollectioninfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyuanpeng on 2018/8/8.
 */
@Service
public class CollectioninfoServiceImp implements CollectioninfoService {
    @Autowired
    private CollectioninfoDAO collectioninfoDAO;
    @Autowired
    private GoodsinfoDAO goodsinfoDAO;
    @Override
    public List<Goodsinfo> findAll(int memberid) {
       List<Collectioninfo> list = collectioninfoDAO.findAll(memberid);
        List<Goodsinfo> list2=new ArrayList<Goodsinfo>();
        for(Collectioninfo c:list){
            list2.add(goodsinfoDAO.findByGoodsId(c.getGoodsid()));
        }
        return list2;
    }

    @Override
    public int addCollection(Collectioninfo collectioninfo) {
        return collectioninfoDAO.addCollection(collectioninfo);
    }

    @Override
    public int deleteColletion(Collectioninfo collectioninfo) {
        return collectioninfoDAO.deleteColletion(collectioninfo);
    }

    @Override
    public Collectioninfo judgeCollection(Collectioninfo collectioninfo) {
        return collectioninfoDAO.judgeCollection(collectioninfo);
    }
}
