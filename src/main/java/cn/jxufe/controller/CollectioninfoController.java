package cn.jxufe.controller;

import cn.jxufe.entity.Collectioninfo;
import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.service.CollectioninfoService;
import cn.jxufe.service.GoodsInfoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liuyuanpeng on 2018/8/8.
 */
@Controller
public class CollectioninfoController {
    @Autowired
    private CollectioninfoService collectioninfoService;
    @Autowired
    private GoodsInfoServer goodsInfoServer;
    @RequestMapping("FindCollectionByMemberId")
    @ResponseBody
    public List<Goodsinfo> findAll(int memberid){

        return collectioninfoService.findAll(memberid);
        //return 1;
    }

    @RequestMapping("addCollection")
    @ResponseBody
    public int addCollection(int goodsId,int memberid) {
        Collectioninfo collectioninfo=new Collectioninfo();
        collectioninfo.setGoodsid(goodsId);collectioninfo.setMemberid(memberid);
        if(collectioninfoService.judgeCollection(collectioninfo)!=null){
            collectioninfoService.deleteColletion(collectioninfo);
            return 0;
        }
        else {
            return collectioninfoService.addCollection(collectioninfo);
        }

    }

    @RequestMapping("deleteColletion")
    @ResponseBody
    public int  deleteColletion(int goodsId,int memberid){
        Collectioninfo collectioninfo=new Collectioninfo();
        collectioninfo.setGoodsid(goodsId);collectioninfo.setMemberid(memberid);
        return collectioninfoService.deleteColletion(collectioninfo);
    }

    @RequestMapping("judgeCollection")
    @ResponseBody
    public int judgeCollection(int goodsId,int memberid) {
        Collectioninfo collectioninfo=new Collectioninfo();
        collectioninfo.setGoodsid(goodsId);collectioninfo.setMemberid(memberid);
        if(collectioninfoService.judgeCollection(collectioninfo)!=null){
            return 1;
        }
        else {
            return 0;
        }

    }

    @RequestMapping("cutgoods_collect_num")
    @ResponseBody
    public int cutgoods_collect_num(int goodsid)
    {
       return goodsInfoServer.cutgoods_collect_num(goodsid);
    }

}
