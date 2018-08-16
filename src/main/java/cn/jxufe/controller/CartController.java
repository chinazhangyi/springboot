package cn.jxufe.controller;

import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.entity.Gouwuping;
import cn.jxufe.service.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhang on 2018/8/10.
 */
@Controller
public class CartController {
    @Autowired
    GoodsInfoServer goodsInfoServer;

    @RequestMapping("putcart{goodsId}")
    @ResponseBody
    public Object putcart(@PathVariable int goodsId, HttpSession session) {
        try {
            Map<Integer, Gouwuping> cart = (Map) session.getAttribute("cart");
            //通过商品的id查找商品，并且变成商品对象
            Goodsinfo g = goodsInfoServer.findGoodById(goodsId);
            //想办法将商品对象包装成购物对象
            Gouwuping gouwuping = new Gouwuping();
            gouwuping.setSize(1);
            gouwuping.setGoodsinfo(g);
            //判断是否存在这个购物车
            if (cart == null) {
                cart = new HashMap(); //不存在，新建一个购物车
            }
            if (cart.get(goodsId) == null) { //再判断这个商品是否存在于购物车中
                cart.put(goodsId, gouwuping); //不存在，将商品的ID，以及购物品添加到cart Map 里面
            } else {
                cart.get(goodsId).setSize(cart.get(goodsId).getSize() + 1); //存在的话，将商品的数量加一
            }
            session.setAttribute("cart", cart);  //在将购物车存入session中
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }


    }

    @RequestMapping("getcart")

    public Object getcart(ModelMap map, HttpSession session) {
        Map cart = (Map) session.getAttribute("cart");
        map.put("cart", cart);

        return "cart";
    }

    @RequestMapping("changecart{goodsId}")
    @ResponseBody
    public Object mincart(@PathVariable int goodsId, HttpSession session, Integer count) {

        Map<Integer, Gouwuping> cart = (Map) session.getAttribute("cart");
        try {
            //先找到session中的购物车

            //然后通过id找到商品
            Goodsinfo g = goodsInfoServer.findGoodById(goodsId);
            //通过id找购物品
            Gouwuping gouwuping = cart.get(goodsId);
            gouwuping.setSize(gouwuping.getSize() + count);
            //如果商品的数量为1，把商品从购物品里面删除
            if (gouwuping.getSize() <= 0) {
                cart.remove(goodsId);
            }
            session.setAttribute("cart", cart);
            System.out.println(cart);

        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
        int totalmoney = 0;
        int num = 0;
        for (Gouwuping g : cart.values()) {
            totalmoney += (g.getGoodsinfo().getGoodsPrice() * g.getSize());
            num += (g.getSize());
        }
        Map map = new HashMap();
        map.put("totalmoney", totalmoney);
        map.put("num", num);
        return map;
    }

    @RequestMapping("deletecart{goodsId}")
    @ResponseBody
    public Object deletegoods(@PathVariable int goodsId, HttpSession session) {
        int totalmoney = 0;
        int num = 0;
        Map<Integer, Gouwuping> cart = (Map) session.getAttribute("cart");
        try {


            //先找到session中的购物车

            //然后通过id找到商品
            Goodsinfo g = goodsInfoServer.findGoodById(goodsId);
            //通过id找购物品
            Gouwuping gouwuping = cart.get(goodsId);

            cart.remove(goodsId);
            session.setAttribute("cart", cart);
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Gouwuping g : cart.values()) {
            totalmoney += (g.getGoodsinfo().getGoodsPrice() * g.getSize());
            num += (g.getSize());
        }
        Map map = new HashMap();
        map.put("totalmoney", totalmoney);
        map.put("num", num);
        return map;
    }

}
