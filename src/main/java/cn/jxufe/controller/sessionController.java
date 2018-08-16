package cn.jxufe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Zhang on 2018/8/10.
 */
@Controller
public class sessionController {

    int totalnum=0;

    @RequestMapping("getsession")
    @ResponseBody
    public Object testseeeion(HttpSession session){
        Object click = session.getAttribute("click");
        int num=1;
        if (click==null){
            num = 1;
        }else {
            num = (Integer)click+1;
        }
        session.setAttribute("click", num);

        totalnum++;

    return "点击了"+totalnum+"次 你点击了"+num+"次";
    }

}
