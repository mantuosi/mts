package com.mantuosi.mts.service.article;

import cn.itcast.common.page.Pagination;

public interface ArticleService {

	Pagination selectPaginationByQuery(Integer pageNo);

	void deleteArticle(Integer id);

	Pagination selectPaginationByQuery(Integer pageNo, String name);
}
