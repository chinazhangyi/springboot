package cn.jxufe.service.impl;

import cn.jxufe.dao.AdvertisementDAO;
import cn.jxufe.entity.Advertisement;
import cn.jxufe.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhang on 2018/8/7.
 */
@Service
public class AdvertisementImpl implements AdvertisementService {
    @Autowired
    private AdvertisementDAO advertisementDAO;
    @Override
    public List<Advertisement> findOnlieList(Map map) {

        return advertisementDAO.findOnLineList(map);
    }
}
