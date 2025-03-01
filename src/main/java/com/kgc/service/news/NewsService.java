package com.kgc.service.news;

import com.kgc.pojo.ResponseMsg;

public interface NewsService {

    /*
        根据创建时间降序展示前5条新闻数据
         */
    ResponseMsg getFiveNewsOrderByCreateDate();
}
