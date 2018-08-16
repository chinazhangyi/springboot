package cn.jxufe.service.impl;

import cn.jxufe.dao.GoodsCommentDAO;
import cn.jxufe.entity.GoodsComment;
import cn.jxufe.service.GoodsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuyuanpeng on 2018/8/7.
 */
@Service
public class GoodsCommentServiceImp implements GoodsCommentService{
    @Autowired
    private GoodsCommentDAO goodsCommentDAO;
    @Override
    public List<GoodsComment> findAll() {
        return goodsCommentDAO.findAll();
    }
    @Override
    public  int insert( GoodsComment goodsComment){
        return  goodsCommentDAO.addComment(goodsComment);
    }

    @Override
    public List<GoodsComment> findCommentByGoodId(int goodisId) {
        return goodsCommentDAO.findCommentByGoodId(goodisId);
    }
}
