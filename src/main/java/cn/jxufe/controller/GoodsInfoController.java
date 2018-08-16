package cn.jxufe.controller;

import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.service.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Zhang on 2018/8/7.
 */
@Controller
public class GoodsInfoController {
    @Autowired
    private GoodsInfoServer goodsInfoServer;

    @RequestMapping("goods")
    @ResponseBody
    public  Object testGoods(){
        return goodsInfoServer.findAllGoods();
    }

    /**
     *
     * @param map
     * @param id
     * @return
     */
    @RequestMapping("product")
    public  String findgood(ModelMap map,Integer id){
        Goodsinfo good = goodsInfoServer.findGoodById(id);
        map.put("good",good);
        System.out.println(good);
        return "product";
    }


    /**
     * 根据传入的商品类型的id查询商品
     * @param map
     * @param catId
     * @return
     */
    @RequestMapping("goodskind")
    @ResponseBody
    public Object findbytype(ModelMap map,Integer catId){
        List<Goodsinfo> goodsByType = goodsInfoServer.findGoodsByType(catId);
       // map.put("goodsByType",goodsByType);
        return goodsByType;
    }

    //刘
    @RequestMapping("findbygoodsid")
    @ResponseBody
    public  Object testfindbyid(int goodsId){
        return goodsInfoServer.findByGoodsId(goodsId);
    }


    @RequestMapping("addGooods")
    @ResponseBody
    public  int addGooods(String goodsSubtitle,String goodsDescription,String memberId,String goodsImage)
    {
        Goodsinfo goodsinfo=new Goodsinfo();
        goodsinfo.setGoodsDescription(goodsDescription);goodsinfo.setGoodsImage(goodsImage);
        goodsinfo.setMemberId(memberId);goodsinfo.setGoodsSubtitle(goodsSubtitle);
        return goodsInfoServer.addGooods(goodsinfo);
    }

    @RequestMapping("addgoods_collect_num")
    @ResponseBody
    public  int  addgoods_collect_num( int goodsid)
    {

        return goodsInfoServer.addgoods_collect_num(goodsid);
    }

    @RequestMapping("addthumbs_up_num")
    @ResponseBody
    public  int  addthumbs_up_num( int goodsid)
    {

        return goodsInfoServer.addthumbs_up_num( goodsid);
    }
    @RequestMapping("cutthumbs_up_num")
    @ResponseBody
    public  int  cutthumbs_up_num( int goodsid)
    {
        return goodsInfoServer.cutthumbs_up_num(goodsid);
    }


    @RequestMapping("addcomment_num")
    @ResponseBody
    public  int  addcomment_num( int goodsid)
    {

        return goodsInfoServer.addcomment_num(goodsid);
    }

    @RequestMapping("cutcomment_num")
    @ResponseBody
    public  int  cutcomment_num( int goodsid)
    {
        return goodsInfoServer.cutcomment_num(goodsid);
    }

    @RequestMapping("findGoodsByMenberid")
    @ResponseBody
    public List<Goodsinfo> findGoodsByMenberid(String memberId) {
        return  goodsInfoServer.findGoodsByMenberid(memberId);
    }




}
