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


    @RequestMapping("product")
    public  String findgood(ModelMap map,Integer id){
        Goodsinfo good = goodsInfoServer.findGoodById(id);
        map.put("good",good);
        System.out.println(good);
        return "product";
    }


//    http://localhost:8080/goodskind?catId=1
//    @RequestMapping("goodskind")
//    @ResponseBody
//    public Object findbytype(Integer catId){
//        List<Goodsinfo> goodsByType = goodsInfoServer.findGoodsByType(catId);
//        return goodsByType;
//    }

    //    http://localhost:8080/goodskind?catId=1


}
