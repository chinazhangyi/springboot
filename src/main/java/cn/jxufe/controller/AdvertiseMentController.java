package cn.jxufe.controller;

import cn.jxufe.entity.Advertisement;
import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.service.AdvertisementService;
import cn.jxufe.service.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhang on 2018/8/7.
 */
@Controller
public class AdvertiseMentController {
    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private GoodsInfoServer getGoodsInfoServer;

    @Autowired
    private GoodsInfoServer goodsInfoServer;

    @RequestMapping("index")
    public String toindex(ModelMap map){
        Map m =new HashMap();
        m.put("advOffline",1);
        List<Advertisement> alist = advertisementService.findOnlieList(m);
        List<Goodsinfo> glist = goodsInfoServer.findAllGoods();
        map.put("alist",alist);
        map.put("glist",glist);
        return "index";
    }



}
