package cn.jxufe.dao;

import cn.jxufe.entity.GoodsComment;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GoodsCommentDAO继承基类
 */
@Repository
public interface GoodsCommentDAO extends MyBatisBaseDao<GoodsComment, Integer> {

    List<GoodsComment> findAll();
    int addComment(GoodsComment goodsComment);
    List<GoodsComment> findCommentByGoodId(@Param("goodisId") int goodisId);
}