package cn.jxufe.entity;

/**
 * Created by Zhang on 2018/8/10.
 */
public class Gouwuping implements java.io.Serializable {

    private Goodsinfo goodsinfo;
    private int size;

    public Gouwuping() {
    }

    public Goodsinfo getGoodsinfo() {
        return goodsinfo;
    }

    public void setGoodsinfo(Goodsinfo goodsinfo) {
        this.goodsinfo = goodsinfo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
