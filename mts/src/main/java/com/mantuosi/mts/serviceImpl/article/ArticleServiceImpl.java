package com.mantuosi.mts.serviceImpl.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantuosi.mts.core.bean.article.Article;
import com.mantuosi.mts.core.bean.article.ArticleQuery;
import com.mantuosi.mts.core.bean.article.ArticleQuery.Criteria;
import com.mantuosi.mts.core.bean.category.Category;
import com.mantuosi.mts.core.dao.article.ArticleDao;
import com.mantuosi.mts.core.dao.category.CategoryDao;
import com.mantuosi.mts.service.article.ArticleService;

import cn.itcast.common.page.Pagination;;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private CategoryDao categoryDao;

	public void deleteArticle(Integer id) {
		// TODO Auto-generated method stub
		articleDao.deleteByPrimaryKey(id);
	}

	public Pagination selectPaginationByQuery(Integer pageNo) {
		ArticleQuery articleQuery = new ArticleQuery();
		articleQuery.setPageNo(Pagination.cpn(pageNo));
		articleQuery.setPageSize(4);
		articleQuery.setOrderByClause("id desc");
		// Criteria criteria = articleQuery.createCriteria();
		StringBuilder params = new StringBuilder();
		Pagination pagination = new Pagination(articleQuery.getPageNo(), articleQuery.getPageSize(),
				articleDao.countByExample(articleQuery));
		List<Article> articleList = articleDao.selectByExample(articleQuery);
		for (Article article : articleList) {
			Category category = categoryDao.selectByPrimaryKey(article.getClassification());
			article.setCategoryName(category.getName());
		}
		pagination.setList(articleList);
		String url = "/article";
		pagination.pageView(url, params.toString());
		return pagination;
	}

	public Pagination selectPaginationByQuery(Integer pageNo, String name) {
		ArticleQuery articleQuery = new ArticleQuery();
		articleQuery.setPageNo(Pagination.cpn(pageNo));
		articleQuery.setPageSize(4);
		articleQuery.setOrderByClause("id desc");
		Criteria criteria = articleQuery.createCriteria();
		StringBuilder params = new StringBuilder();
		if (name != null) {
			criteria.andTitleLike("%" + name + "%");
			params.append("title=").append(name);
		}
		Pagination pagination = new Pagination(articleQuery.getPageNo(), articleQuery.getPageSize(),
				articleDao.countByExample(articleQuery));
		List<Article> articleList = articleDao.selectByExample(articleQuery);
		for (Article article : articleList) {
			Category category = categoryDao.selectByPrimaryKey(article.getClassification());
			article.setCategoryName(category.getName());
		}
		pagination.setList(articleList);
		String url = "/article";
		pagination.pageView(url, params.toString());
		return pagination;
	}
}
