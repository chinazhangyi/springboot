package cn.jxufe.controller;

import cn.jxufe.entity.GoodsComment;
import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.entity.Searchinfo;
import cn.jxufe.service.GoodsCommentService;
import cn.jxufe.service.GoodsInfoServer;
import cn.jxufe.service.SearchinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liuyuanpeng on 2018/8/8.
 */
@Controller
public class SearchinfoController {
    @Autowired
    private GoodsCommentService goodsCommentService;
    @Autowired
    private SearchinfoService searchinfoService;
    @Autowired
    private GoodsInfoServer goodsInfoServer;

    @RequestMapping("addSearchinfo")
    @ResponseBody
    public Searchinfo addSearchinfo(int memberId,String searchKey ){
        Searchinfo searchinfo=new Searchinfo();
        searchinfo.setMemberId(memberId);searchinfo.setSearchKey(searchKey);

        if(searchinfoService.addSearchinfo(searchinfo)!=0)
        {
            return searchinfoService.findNewSearchinfo();

        }
        else {
            return null;
        }
    }

    @RequestMapping("findSearchByMenberId")
    @ResponseBody
    public List<Searchinfo> findSearchByMenberId(int memberid) {
        return searchinfoService.findById(memberid);
    }

    @RequestMapping("deleteSearchinfoBymemberId")
    @ResponseBody
    public int deleteSearchinfoBymemberId(int memberId) {
        return searchinfoService.deleteSearchinfoBymemberId(memberId);
    }

    @RequestMapping("findByGoodsNameLike")
    @ResponseBody
    public List<Goodsinfo> findByGoodsNameLike(String goodsName) {
        return searchinfoService.findByGoodsNameLike(goodsName);
    }

    @RequestMapping("goodsCommentInsert")
    @ResponseBody
    public int goodsCommentInsert(int goodisId, int scommMemberid, String scommContent, String memberName) {
        GoodsComment goodsComment = new GoodsComment();
        goodsComment.setGoodisId(goodisId);
        goodsComment.setScommMemberid(scommMemberid);
        goodsComment.setScommMembername(memberName);
        goodsComment.setScommContent(scommContent);
        goodsComment.setScommMemberavatar("/images/icon/DefaultAvatar.jpg");
        return goodsCommentService.insert(goodsComment);
    }



}
