package cn.jxufe.controller;

import cn.jxufe.entity.GoodsCategory;
import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.service.GoodsCategoryService;
import cn.jxufe.service.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Zhang on 2018/8/8.
 */
@Controller
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Autowired
    private GoodsInfoServer goodsInfoServer;
    @RequestMapping("category")
    public String findtype(ModelMap map,Integer catId){
        List<GoodsCategory> gtype = goodsCategoryService.findtype();
       // List<Goodsinfo> goodsByType = goodsInfoServer.findGoodsByType(catId);
     //   map.put("goodsByType",goodsByType);
        map.put("gtype",gtype);
        return "category";
    }
}
