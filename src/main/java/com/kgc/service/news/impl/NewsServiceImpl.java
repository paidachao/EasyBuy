package com.kgc.service.news.impl;

import com.kgc.dao.news.NewsMapper;
import com.kgc.pojo.News;
import com.kgc.pojo.ResponseMsg;
import com.kgc.service.news.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);
    @Autowired
    private NewsMapper newsMapper;

    /*
    根据创建时间降序展示前5条新闻数据
     */
    @Override
    public ResponseMsg getFiveNewsOrderByCreateDate(){
        logger.info("NewsServiceImpl getFiveNewsOrderByCreateDate start... ");
        ResponseMsg msg = new ResponseMsg();
        List<News> newsLst = newsMapper.getFiveNewsOrderByCreateDate();
        if(newsLst != null && !newsLst.isEmpty()){
            msg.setCode("200");
            msg.setMsg("success");
            msg.setData(newsLst);
        }else {
            msg.setCode("500");
            msg.setMsg("fail");
            msg.setData(newsLst);
        }
        return msg;
    }
}
