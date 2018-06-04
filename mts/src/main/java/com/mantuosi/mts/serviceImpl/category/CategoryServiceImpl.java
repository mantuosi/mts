package com.mantuosi.mts.serviceImpl.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantuosi.mts.core.bean.category.Category;
import com.mantuosi.mts.core.bean.category.CategoryQuery;
import com.mantuosi.mts.core.bean.category.CategoryQuery.Criteria;
import com.mantuosi.mts.core.dao.category.CategoryDao;
import com.mantuosi.mts.service.category.CategoryService;

import cn.itcast.common.page.Pagination;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	public Pagination selectParentPaginationByQuery(Integer pageNo) {
		CategoryQuery categoryQuery = new CategoryQuery();
		categoryQuery.setPageNo(Pagination.cpn(pageNo));
		categoryQuery.setPageSize(10);
		String url = "/category";
		StringBuilder params = new StringBuilder();
		Criteria criteria = categoryQuery.createCriteria();
		criteria.andPidEqualTo(0);
		Pagination pagination = new Pagination(categoryQuery.getPageNo(), categoryQuery.getPageSize(),
				categoryDao.countByExample(categoryQuery));
		pagination.setList(categoryDao.selectByExample(categoryQuery));
		pagination.pageView(url, params.toString());
		return pagination;
	}

	public List<Category> selectScCategory(Integer id) {
		CategoryQuery categoryQuery = new CategoryQuery();
		Criteria criteria = categoryQuery.createCriteria();
		criteria.andPidEqualTo(id);

		List<Category> li = categoryDao.selectByExample(categoryQuery);
		for (Category c : li) {
			c.setPname(categoryDao.selectByPrimaryKey(id).getName());
		}
		return li;
	}

	public void insertCategory(Category category) {
		categoryDao.insertSelective(category);
	}

	public void deleteParentCategory(Integer id) {
		CategoryQuery categoryQuery = new CategoryQuery();
		Criteria criteria = categoryQuery.createCriteria();
		criteria.andPidEqualTo(id);
		List<Category> li = categoryDao.selectByExample(categoryQuery);
		for (Category c : li) {
			categoryDao.deleteByPrimaryKey(c.getId());
		}
		categoryDao.deleteByPrimaryKey(id);
	}

	public void deleteByPrimaryKey(Integer id) {
		categoryDao.deleteByPrimaryKey(id);
	}
}
