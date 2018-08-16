package cn.jxufe.controller;

import cn.jxufe.entity.GoodsComment;
import cn.jxufe.entity.Goodsinfo;
import cn.jxufe.entity.Memberinfo;
import cn.jxufe.entity.Searchinfo;
import cn.jxufe.service.CollectioninfoService;
import cn.jxufe.service.GoodsCommentService;
import cn.jxufe.service.GoodsInfoServer;
import cn.jxufe.service.SearchinfoService;
import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by Zhang on 2018/8/3.
 */
@Controller
public class PageController {
    @Autowired
    private GoodsCommentService goodsCommentService;
    @Autowired
    private SearchinfoService searchinfoService;
    @Autowired
    private CollectioninfoService collectioninfoService;
    @Autowired
    private GoodsInfoServer goodsInfoServer;

    @RequestMapping("comments")
    @ResponseBody
    public int Comments(int goodsId,HttpSession session){
        Goodsinfo goodsinfo= goodsInfoServer.findByGoodsId(goodsId);
        session.setAttribute("goodsinfo", goodsinfo);
        return 1;
    }

    @RequestMapping("comment")
    public String toComment(ModelMap map,HttpSession session){
        Goodsinfo goodsinfo=(Goodsinfo)session.getAttribute("goodsinfo");
        List<GoodsComment> list=goodsCommentService.findCommentByGoodId(goodsinfo.getGoodsId());
        map.put("commentlist",list);
        return "comment";
    }



    @RequestMapping("favorite")
    public String toFavorite(ModelMap map,HttpSession session){
        Memberinfo memberinfo= (Memberinfo)session.getAttribute("member");
        List<Goodsinfo> list=collectioninfoService.findAll(memberinfo.getMemberId());
        map.put("goodsinfolist",list);
        return "favorite";
    }

//    @RequestMapping("index")
//    public String toIndex(HttpSession session){
//        Memberinfo memberinfo=new Memberinfo();
//        memberinfo.setMemberId(1);
//        Goodsinfo goodsinfo1=new Goodsinfo();
//        goodsinfo1.setGoodsId(1);
//        Goodsinfo goodsinfo=goodsInfoServer.findByGoodsId(goodsinfo1.getGoodsId());
//        session.setAttribute("memberinfo", memberinfo);
//        session.setAttribute("goodsinfo",goodsinfo);
//        return "index";
//    }

//    @RequestMapping("upload_file")
//    public String toUpload_file(HttpSession session){
//        Memberinfo memberinfo=new Memberinfo();
//        memberinfo.setMemberId(1);
//        memberinfo.setMemberName("江财4号");
//        Goodsinfo goodsinfo=new Goodsinfo();
//        goodsinfo.setGoodsId(1);
//        session.setAttribute("memberinfo", memberinfo);
//        session.setAttribute("goodsinfo",goodsinfo);
//        return "upload_file";
//    }


    @RequestMapping("search")
    public String tosearch(ModelMap map,HttpSession session){
        Memberinfo memberinfo=(Memberinfo)session.getAttribute("member");
        List<Searchinfo> list=searchinfoService.findById(memberinfo.getMemberId());
        map.put("searchlist",list);
        return "search";
    }
    //注入一个session
    @RequestMapping("getSession")
    @ResponseBody
    public void getSession(HttpSession session){
        Memberinfo memberinfo=new Memberinfo();
        session.setAttribute("memberinfo",memberinfo);
    }

    @RequestMapping("uploadimage")
    @ResponseBody
    public Object uploadFile(@RequestParam("fs") MultipartFile file){
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        String accessKeyId = "LTAI6D9vZzrSgSqr";
        String accessKeySecret = "mK0XcIm6BFhowuOEvBBzmRXZmAmTDD";
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String buckName="newwld";
        try {
            InputStream inputStream=file.getInputStream();
            ossClient.putObject(buckName,file.getOriginalFilename(), inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ossClient.shutdown();
        }

        return endpoint.replace("http://","http://"+buckName+".")+"/"+file.getOriginalFilename();

    }

    @RequestMapping("product_list")
    public String product_list(ModelMap map,HttpSession session){
        Memberinfo memberinfo=(Memberinfo)session.getAttribute("member");
        String str=memberinfo.getMemberId().toString();
        List<Goodsinfo> list= goodsInfoServer.findGoodsByMenberid(str);
        map.put("searchlist",list);
        return "product_list";
    }
//    public Object uploadimage(@RequestParam("fs") MultipartFile f,HttpServletRequest req){
//        String path=req.getSession().getServletContext().getRealPath("upload/");
//        String fileName= UUID.randomUUID().toString()+f.getOriginalFilename();
//        try {
//            FileOutputStream fou = new FileOutputStream(path + fileName);
//            fou.write(f.getBytes());
//            fou.close();
//            return "/upload/"+fileName;
//        }catch (Exception ex){
//            ex.printStackTrace();
//            return null;
//        }
//    }


    @RequestMapping("{url}")
    public String getUser(@PathVariable String url){
        return url;
    }


}
