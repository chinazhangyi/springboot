package cn.jxufe.service;

import cn.jxufe.entity.Goodsinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zhang on 2018/8/7.
 */
public interface GoodsInfoServer {
    public List<Goodsinfo>findAllGoods();
    public Goodsinfo findGoodById(Integer id);
    public List<Goodsinfo>findGoodsByType(Integer cId);

    //刘
    public  Goodsinfo findByGoodsId(int goodsId);
    public  int addGooods(Goodsinfo goodsinfo);
    public int addthumbs_up_num( int goodsid);
    public int cutthumbs_up_num(int goodsid);
    public int addgoods_collect_num( int goodsid);
    public int addcomment_num(int goodsid);
    public int cutcomment_num(int goodsid);
    public int cutgoods_collect_num( int goodsid);
    public List<Goodsinfo> findGoodsByMenberid(String memberId);
}
