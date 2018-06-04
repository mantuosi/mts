package com.mantuosi.mts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mantuosi.mts.common.utils.PageList;
import com.mantuosi.mts.service.article.ArticleService;

import cn.itcast.common.page.Pagination;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/admin/article")
	public String toArticle(Model model, Integer pageNo) {
		Pagination pagination = articleService.selectPaginationByQuery(pageNo);
		List<Integer> pg = PageList.listTotalPage(pagination.getTotalPage());
		model.addAttribute("pagination", pagination);
		model.addAttribute("articleNum", pagination.getTotalCount());
		model.addAttribute("lastPage", pagination.getTotalPage());
		model.addAttribute("totalPage", pg);
		return "article";
	}

	@RequestMapping(value = "/admin/searchArticle")
	public String searchArticle(String name, Integer pageNo, Model model) {
		Pagination pagination = articleService.selectPaginationByQuery(pageNo, name);
		List<Integer> pg = PageList.listTotalPage(pagination.getTotalPage());
		if (null != name) {
			model.addAttribute("pagination", pagination);
			model.addAttribute("value", name);
			model.addAttribute("articleNum", pagination.getTotalCount());
			model.addAttribute("lastPage", pagination.getTotalPage());
			model.addAttribute("totalPage", pg);
			return "article";
		} else {
			return "rediect:/admin/article";
		}
	}

	@RequestMapping(value = "/admin/deleteArticle")
	public void deleteArtical(Integer id, HttpServletResponse response) throws IOException {
		articleService.deleteArticle(id);
		String url = "/admin/article";
		response.getWriter().write(url);
	}

	@RequestMapping(value = "/admin/deleteArticles")
	public void deleteArticles(String ids, HttpServletResponse response) throws IOException {
		String[] mts = ids.split(",");
		for (String id : mts) {
			articleService.deleteArticle(Integer.parseInt(id));
		}
		String url = "/admin/article";
		response.getWriter().write(url);
	}

}
