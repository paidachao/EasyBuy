package com.kgc.controller.news;

import com.kgc.pojo.ResponseMsg;
import com.kgc.service.news.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {
    private Logger logger = LoggerFactory.getLogger(NewsController.class);
    /*
    调用newsServiceImpl.getFiveNewsOrderByCreateDate(),根据创建时间降序展示前5条新闻数据
     */
    @Autowired
    private NewsService newsService;
    @RequestMapping("getFiveNewsOrderByCreateDate")
    @ResponseBody
    @CrossOrigin
    public ResponseMsg getFiveNewsOrderByCreateDate() {
        logger.info("NewsController getFiveNewsOrderByCreateDate start...");
        ResponseMsg msg = new ResponseMsg();
        msg = newsService.getFiveNewsOrderByCreateDate();
        logger.debug("NewsController getFiveNewsOrderByCreateDate msg "+ msg);
        return msg;
    }
}
