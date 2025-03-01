package com.kgc.service.category.impl;

import com.alibaba.fastjson.JSON;
import com.kgc.dao.category.CategoryMapper;
import com.kgc.enums.IndexEnum;
import com.kgc.pojo.Category;
import com.kgc.pojo.ResponseMsg;
import com.kgc.service.category.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /*
    将所有的category数据使用hash存放到redis中
     */
    public void saveCategoryInRedis() {
        logger.info("CategoryServiceImpl saveCategoryInRedis start...");
        List<Category> categoryList = categoryMapper.selectAll();
        logger.debug("CategoryServiceImpl saveCategoryInRedis categoryList " + categoryList);
        for (Category category : categoryList) {
            redisTemplate.opsForHash().put("categories", String.valueOf(category.getId()), JSON.toJSONString(category));
        }
        logger.info("CategoryServiceImpl saveCategoryInRedis end...");
    }
    /*
    从redis中获取用户集合
    如果redis为空 调用saveCategoryInRedis存放数据
     */
    public List<Category> getListFromRedis() {
        logger.info("CategoryServiceImpl getListFromRedis start...");
        List<Category> categoryList = new ArrayList<>();
        List<Object> values = redisTemplate.opsForHash().values("categories");
        redisTemplate.delete("categories");
        if(values.isEmpty()){
            saveCategoryInRedis();
        }
        for (Object value : values) {
            categoryList.add(JSON.parseObject((String) value, Category.class));
        }
        logger.debug("CategoryServiceImpl getListFromRedis categoryList " + categoryList);
        return categoryList;
    }
    /*
    通过parentId查询category集合
     */
    @Override
    public ResponseMsg selectCategoryByParentId(int parentId) {
        logger.info("CategoryServiceImpl selectCategoryByParentId start...");
        ResponseMsg msg = new ResponseMsg();
        List<Category> categoryList = getListFromRedis();

        if(categoryList.isEmpty()){
            msg.setCode("500");
            msg.setMsg("get category list is empty");
            return msg;
        }
        List<Category> newCategoryList = new ArrayList<>();
        for (Category category : categoryList) {

            if(category.getParentId() == parentId){
                if(category.getParentId() == 0){
                    category.setPicName(IndexEnum.CATEGORY_PATH + category.getPicName());
                }
                newCategoryList.add(category);
            }
        }
        logger.debug("CategoryServiceImpl selectCategoryByParentId parentId = "+ newCategoryList+" categoryList " + newCategoryList.toString());
        if (!newCategoryList.isEmpty()) {
            msg.setCode("200");
            msg.setMsg("success");
            msg.setData(newCategoryList);
        }else{
            msg.setCode("500");
            msg.setMsg("error");
        }
        return msg;
    }
}
