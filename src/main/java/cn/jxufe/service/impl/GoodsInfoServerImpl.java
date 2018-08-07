package cn.jxufe.service.impl;

import cn.jxufe.dao.GoodsinfoDAO;
import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.service.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhang on 2018/8/7.
 */
@Service
public class GoodsInfoServerImpl implements GoodsInfoServer {

    @Autowired
    private GoodsinfoDAO goodsinfoDAO;


    @Override
    public List<Goodsinfo> findAllGoods() {
        return goodsinfoDAO.findAllGoods();
    }
}
