package cn.jxufe.dao;

import cn.jxufe.entity.Advertisement;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * AdvertisementDAO继承基类
 */
@Repository
public interface AdvertisementDAO extends MyBatisBaseDao<Advertisement, Integer> {
    public List<Advertisement> findOnLineList(@Param("map") Map kv);
}