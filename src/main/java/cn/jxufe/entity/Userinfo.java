package cn.jxufe.entity;

import java.io.Serializable;
import java.util.Random;

/**
 * @Author 合众艾特信息技术有限公司-研发部-吴文杰
 * @Date 2018/7/25-17:18
 * @Description
 */
public class Userinfo implements Serializable {

    private int uid;
    private String uname;
    private String password;
    private int roleid;
    private int score;
    private String createtime;

    @Override
    public String toString() {
        return "Userinfo{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", roleid=" + roleid +
                ", score=" + score +
                ", createtime='" + createtime + '\'' +
                '}';
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Userinfo() {

    }

    public Userinfo( String uname, String password, int roleid) {

        this.uname = uname;
        this.password = password;
        this.roleid = roleid;
        this.score=new Random().nextInt(32)+1;
    }
    public Userinfo( String uname, String password, int roleid,int score) {

        this.uname = uname;
        this.password = password;
        this.roleid = roleid;
        this.score=score;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
}
/*
代码手中走~佛祖心中留！求永无BUG！
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
            \  .-\__  `-`  ___/-. /
          ___`. .'  /--.--\  `. . __
       ."" '<  `.___\_<|>_/___.'  >'"".
      | | :  `- \`.;`\ _ /`;.`/ - ` : | |
      \  \ `-.   \_ __\ /__ _/   .-` /  /
 ======`-.____`-.___\_____/___.-`____.-'======
 */
