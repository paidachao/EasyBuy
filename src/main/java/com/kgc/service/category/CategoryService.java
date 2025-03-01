package com.kgc.service.category;

import com.kgc.pojo.ResponseMsg;

import java.util.List;

public interface CategoryService {
    /*
        通过parentId查询category集合
         */
    ResponseMsg selectCategoryByParentId(int parentId);

}
