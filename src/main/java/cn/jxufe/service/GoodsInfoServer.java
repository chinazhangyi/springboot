package cn.jxufe.service;

import cn.jxufe.entity.Goodsinfo;

import java.util.List;

/**
 * Created by Zhang on 2018/8/7.
 */
public interface GoodsInfoServer {
    public List<Goodsinfo>findAllGoods();
    public Goodsinfo findGoodById(Integer id);
}
