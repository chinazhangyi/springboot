package cn.jxufe.service.impl;

import cn.jxufe.dao.GoodsinfoDAO;
import cn.jxufe.dao.SearchinfoDAO;
import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.entity.Searchinfo;
import cn.jxufe.service.SearchinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuyuanpeng on 2018/8/8.
 */
@Service
public class SearchinfoServiceImp implements SearchinfoService {
    @Autowired
    private SearchinfoDAO searchinfoDAO;
    @Autowired
    private GoodsinfoDAO goodsinfoDAO;
    @Override
    public int addSearchinfo(Searchinfo searchinfo) {
        return searchinfoDAO.addSearchinfo(searchinfo);
    }

    @Override
    public List<Goodsinfo> Search(String searchKey) {
        return null;
    }

    @Override
    public List<Searchinfo> findById(int memberId) {
        return searchinfoDAO.findById(memberId);
    }

    @Override
    public int deleteSearchinfoBymemberId(int memberId) {
        return searchinfoDAO.deleteSearchinfoBymemberId(memberId);
    }

    @Override
    public List<Goodsinfo> findByGoodsNameLike(String goodsName) {
        return goodsinfoDAO.findByGoodsNameLike(goodsName);
    }

    @Override
    public Searchinfo findNewSearchinfo() {
        return searchinfoDAO.findNewSearchinfo();
    }
}
