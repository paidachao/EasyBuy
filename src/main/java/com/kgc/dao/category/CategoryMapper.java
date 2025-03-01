package com.kgc.dao.category;

import com.kgc.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> selectCategoryByParentId(int parentId);
    List<Category> selectAll();
}
