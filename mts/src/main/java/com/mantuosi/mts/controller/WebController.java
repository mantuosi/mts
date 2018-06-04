package com.mantuosi.mts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mantuosi.mts.common.utils.RequestUtils;
import com.mantuosi.mts.core.bean.tickets.Tickets;
import com.mantuosi.mts.core.bean.users.Users;
import com.mantuosi.mts.service.tickets.TicketsService;
import com.mantuosi.mts.service.user.UserService;
import com.mantuosi.mts.service.users.UsersService;

import cn.itcast.common.page.Pagination;

@Controller
public class WebController {

	@Autowired
	private TicketsService ticketsService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public ModelAndView toIndex() {
		return new ModelAndView("/index");
	}

	@RequestMapping(value = "/admin/index")
	public String Index() {
		return "index";
	}

	@RequestMapping(value = "/login")
	public String ToLogin() {
		return "login";
	}

	@RequestMapping(value = "/loginWithRedis")
	public String login(String username, String userpwd, HttpServletRequest request) {
		String ipaddr = RequestUtils.getIpAddrFinal(request);
		boolean mts = userService.loginToRedis(ipaddr, username, userpwd);
		if (mts) {
			return "redirect:/admin/index";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		String ipaddr = RequestUtils.getIpAddrFinal(request);
		userService.logoutFromRedis(ipaddr);
		return "redirect:/login";
	}

	@RequestMapping(value = "/admin/notice")
	public String ToNotice() {
		return "notice";
	}

	@RequestMapping(value = "/admin/comment")
	public String ToComment() {
		return "comment";
	}

	@RequestMapping(value = "/admin/flink")
	public String ToFlink() {
		return "flink";
	}

	@RequestMapping(value = "/admin/manage-user")
	public String ToManage_user() {
		return "manage-user";
	}

	@RequestMapping(value = "/admin/loginlog")
	public String ToLoginlog() {
		return "loginlog";
	}

	@RequestMapping(value = "/admin/setting")
	public String ToSetting() {
		return "setting";
	}

	@RequestMapping(value = "/admin/readset")
	public String ToReadset() {
		return "readset";
	}

	@RequestMapping(value = "/admin/addArticle.do")
	public String ToAddArticle() {
		return "add-article";
	}

	@RequestMapping(value = "/admin/addFlink.do")
	public String ToAddFlink() {
		return "add-flink";
	}

	@RequestMapping(value = "/admin/asd")
	public String ToAsd() {
		return "asd";
	}

	@RequestMapping(value = "/all")
	public String toAll(Model model, Integer pageNo) {
		Pagination pagination = ticketsService.selectPaginationByQuery(pageNo);
		model.addAttribute("pagination", pagination);
		return "all";
	}

	@RequestMapping(value = "/dam")
	public String toDam(Model model, Integer pageNo) {
		Pagination pagination = ticketsService.selectPaginationByQueryAddress(pageNo);
		model.addAttribute("pagination", pagination);
		return "dam";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/userList")
	public String toUserList(Model model, Integer pageNo) {
		Pagination pagination = ticketsService.selectPaginationByQueryUserAndAddress(pageNo);
		List<Tickets> mts = (List<Tickets>) pagination.getList();
		List<Users> users = new ArrayList<Users>();
		for (Tickets ti : mts) {
			String uid = ti.getUid();
			Users tuser = usersService.selectUsersById(uid);
			users.add(tuser);
		}
		model.addAttribute("users", users);
		return "userList";
	}

}
