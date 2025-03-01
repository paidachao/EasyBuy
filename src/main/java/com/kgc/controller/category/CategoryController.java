package com.kgc.controller.category;

import com.kgc.pojo.Category;
import com.kgc.pojo.ResponseMsg;
import com.kgc.service.category.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("selectCategoryByParentId")
    @CrossOrigin
    public ResponseMsg selectCategoryByParentId(int parentId){
        logger.info("CategoryController selectCategoryByParentId parentId = " + parentId);
        ResponseMsg msg = categoryService.selectCategoryByParentId(parentId);
        logger.debug("CategoryController selectCategoryByParentId parentId = " + parentId + " msg = " + msg);
        return msg;
    }
}
