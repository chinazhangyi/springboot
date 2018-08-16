package cn.jxufe.service;

import cn.jxufe.entity.GoodsComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liuyuanpeng on 2018/8/7.
 */
public interface GoodsCommentService {
    List<GoodsComment> findAll();
    int insert(GoodsComment goodsComment);
    List<GoodsComment> findCommentByGoodId( int goodisId);
}
