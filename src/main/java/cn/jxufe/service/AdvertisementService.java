package cn.jxufe.service;

import cn.jxufe.entity.Advertisement;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhang on 2018/8/7.
 */
public interface AdvertisementService {
    public List<Advertisement> findOnlieList(Map map);
}
