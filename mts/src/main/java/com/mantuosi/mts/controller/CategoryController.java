package com.mantuosi.mts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mantuosi.mts.core.bean.category.Category;
import com.mantuosi.mts.service.category.CategoryService;

import cn.itcast.common.page.Pagination;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/admin/category")
	public String ToCategory(Model model, Integer pageNo) {
		Pagination pagination = categoryService.selectParentPaginationByQuery(pageNo);
		model.addAttribute("pagination", pagination);
		return "category";
	}

	@RequestMapping(value = "/admin/scCategory")
	public @ResponseBody List<Category> CategorySc(Integer pageNo, Integer id) {
		List<Category> category = categoryService.selectScCategory(id);
		return category;
	}

	@RequestMapping(value = "/admin/addCategory")
	public String addCategory(Category category) {
		categoryService.insertCategory(category);
		return "redirect:/category";
	}

	@RequestMapping(value = "/admin/delPcategory")
	public void delPcategory(Integer id, HttpServletResponse response) throws IOException {
		categoryService.deleteParentCategory(id);
		response.getWriter().write("/category");
	}

	@RequestMapping(value = "/admin/delScCategory")
	public String delScCategory(Integer id) {

		return "redirect:/admin/category";
	}
}
