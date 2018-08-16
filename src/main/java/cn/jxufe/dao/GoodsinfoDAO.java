package cn.jxufe.dao;

import cn.jxufe.entity.Goodsinfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GoodsinfoDAO继承基类
 */
@Repository
public interface GoodsinfoDAO extends MyBatisBaseDao<Goodsinfo, Integer> {
    /**
     *
     * @return
     */
    public List<Goodsinfo> findAllGoods();

    public List<Goodsinfo> findGoodsByType(@Param("cId")Integer cId);

    public  Goodsinfo findByGoodsId(@Param("goodsId") int goodsId);
    public List<Goodsinfo> findByGoodsNameLike(@Param("goodsName") String goodsName);
    public  int addGooods(Goodsinfo goodsinfo);
    public int addthumbs_up_num(@Param("goodsid") int goodsid);
    public int cutthumbs_up_num(@Param("goodsid") int goodsid);
    public int addgoods_collect_num(@Param("goodsid") int goodsid);
    public int cutgoods_collect_num(@Param("goodsid") int goodsid);
    public int addcomment_num(@Param("goodsid") int goodsid);
    public int cutcomment_num(@Param("goodsid") int goodsid);
    public  List<Goodsinfo> findGoodsByMenberid(@Param("memberId") String memberId);

}