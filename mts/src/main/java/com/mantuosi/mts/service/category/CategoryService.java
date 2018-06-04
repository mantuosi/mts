package com.mantuosi.mts.service.category;

import java.util.List;

import com.mantuosi.mts.core.bean.category.Category;

import cn.itcast.common.page.Pagination;

public interface CategoryService {

	Pagination selectParentPaginationByQuery(Integer pageNo);

	List<Category> selectScCategory(Integer id);

	void insertCategory(Category category);

	void deleteParentCategory(Integer id);

	void deleteByPrimaryKey(Integer id);
}
