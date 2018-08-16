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

    @Override
    public Goodsinfo findGoodById(Integer id) {
        return goodsinfoDAO.selectByPrimaryKey(id);
    }

    @Override
    public List<Goodsinfo> findGoodsByType(Integer cId) {
        return goodsinfoDAO.findGoodsByType(cId);
    }

    @Override
    public Goodsinfo findByGoodsId(int goodsId) {
        return goodsinfoDAO.findByGoodsId(goodsId);
    }

    @Override
    public int addGooods(Goodsinfo goodsinfo) {
        return goodsinfoDAO.addGooods(goodsinfo);
    }

    @Override
    public int addgoods_collect_num( int goodsid) {
        return goodsinfoDAO.addgoods_collect_num(goodsid);
    }

    @Override
    public int addthumbs_up_num( int goodsid) {
        return goodsinfoDAO.addthumbs_up_num(goodsid);
    }

    @Override
    public int cutthumbs_up_num(int goodsid) {
        return goodsinfoDAO.cutthumbs_up_num(goodsid);
    }

    @Override
    public int addcomment_num(int goodsid) {
        return goodsinfoDAO.addcomment_num(goodsid);
    }

    @Override
    public int cutcomment_num(int goodsid) {
        return goodsinfoDAO.cutcomment_num(goodsid);
    }

    @Override
    public int cutgoods_collect_num(int goodsid) {
        return goodsinfoDAO.cutgoods_collect_num(goodsid);
    }

    @Override
    public List<Goodsinfo> findGoodsByMenberid(String memberId) {
        return goodsinfoDAO.findGoodsByMenberid(memberId);
    }
}
