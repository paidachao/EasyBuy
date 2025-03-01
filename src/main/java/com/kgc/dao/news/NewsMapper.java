package com.kgc.dao.news;

import com.kgc.pojo.News;

import java.util.List;

public interface NewsMapper {

    List<News> getFiveNewsOrderByCreateDate();
}
