package com.mantuosi.mts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mantuosi.mts.common.utils.PageList;
import com.mantuosi.mts.core.bean.notice.Notice;
import com.mantuosi.mts.service.notice.NoticeService;

import cn.itcast.common.page.Pagination;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "/admin/notice")
	public String ToNotice(Model model, Integer pageNo) {
		Pagination pagination = noticeService.selectPaginationByQuery(pageNo);
		List<Integer> pg = PageList.listTotalPage(pagination.getTotalPage());
		model.addAttribute("pagination", pagination);
		model.addAttribute("noticeNum", pagination.getTotalCount());
		model.addAttribute("lastPage", pagination.getTotalPage());
		model.addAttribute("totalPage", pg);
		return "notice";
	}

	@RequestMapping(value = "/admin/add-notice")
	public String addNotice() {
		return "add-notice";
	}

	@RequestMapping(value = "/admin/deleteNotice")
	public void deleteNotice(Integer id, HttpServletResponse response) throws IOException {
		noticeService.deleteNoticeByPrimaryKey(id);
		String url = "/admin/notice";
		response.getWriter().write(url);
	}

	@RequestMapping(value = "/admin/deleteNotices")
	public void deleteArticles(String ids, HttpServletResponse response) throws IOException {
		String[] mts = ids.split(",");
		for (String id : mts) {
			noticeService.deleteNoticeByPrimaryKey(Integer.parseInt(id));
		}
		String url = "/admin/notice";
		response.getWriter().write(url);
	}

	@RequestMapping(value = "/admin/addNotice")
	public String insertNotice(Notice notice) {
		noticeService.insertNotice(notice);
		return "redirect:/admin/notice";
	}

	@RequestMapping(value = "/admin/viewNotice")
	public String viewNotice(Integer id, Model model) {
		Notice notice = noticeService.selectByPrimaryKey(id);
		model.addAttribute("notice", notice);
		return "view-notice";
	}

}
