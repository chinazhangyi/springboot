package cn.jxufe.service;

import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.entity.Searchinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liuyuanpeng on 2018/8/8.
 */
public interface SearchinfoService {
    public int addSearchinfo(Searchinfo searchinfo);
    public List<Goodsinfo> Search(String searchKey);
    public List<Searchinfo> findById(int memberId);
    public int deleteSearchinfoBymemberId(int memberId);
    public List<Goodsinfo> findByGoodsNameLike(String goodsName);
    Searchinfo findNewSearchinfo();
}
