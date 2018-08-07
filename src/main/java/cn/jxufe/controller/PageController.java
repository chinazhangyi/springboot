package cn.jxufe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zhang on 2018/8/3.
 */
@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String getUser(@PathVariable String page){
        return page;
    }


}
