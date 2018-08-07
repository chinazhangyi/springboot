package cn.jxufe.controller;

import cn.jxufe.service.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}