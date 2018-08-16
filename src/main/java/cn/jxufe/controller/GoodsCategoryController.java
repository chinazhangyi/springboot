package cn.jxufe.controller;

import cn.jxufe.entity.GoodsCategory;
import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.service.GoodsCategoryService;
import cn.jxufe.service.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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
    public String findgoodskind(ModelMap map){
        List<GoodsCategory> gtype = goodsCategoryService.findtype();
        map.put("gtype",gtype);
        return "category";
    }

    @RequestMapping("category{cId}")
    public Map findtype(ModelMap map,@PathVariable Integer cId){
       // List<GoodsCategory> gtype = goodsCategoryService.findtype();
        List<Goodsinfo> goodsByType = goodsInfoServer.findGoodsByType(cId);
        map.put("goodsByType",goodsByType);
       // map.put("gtype",gtype);
        return map;
    }
}
