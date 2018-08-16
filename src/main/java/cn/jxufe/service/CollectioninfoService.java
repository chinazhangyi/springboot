package cn.jxufe.service;

import cn.jxufe.entity.Collectioninfo;
import cn.jxufe.entity.GoodsComment;
import cn.jxufe.entity.Goodsinfo;

import java.util.List;

/**
 * Created by liuyuanpeng on 2018/8/7.
 */
public interface CollectioninfoService {
    List<Goodsinfo> findAll(int memberid);
    int  addCollection(Collectioninfo collectioninfo);
    int  deleteColletion(Collectioninfo collectioninfo);
    Collectioninfo judgeCollection(Collectioninfo collectioninfo);
}
