package com.mantuosi.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mantuosi.mts.service.user.UserService;

@Controller
public class WebController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index")
	public String Index() {
		return "index";
	}

	@RequestMapping(value = "/article")
	public String ToArticle() {
		return "article";
	}

	@RequestMapping(value = "/notice")
	public String ToNotice() {
		return "notice";
	}

	@RequestMapping(value = "/comment")
	public String ToComment() {
		return "comment";
	}

	@RequestMapping(value = "/category")
	public String ToCategory() {
		return "category";
	}

	@RequestMapping(value = "/flink")
	public String ToFlink() {
		return "flink";
	}

	@RequestMapping(value = "/manage-user")
	public String ToManage_user() {
		return "manage-user";
	}

	@RequestMapping(value = "/loginlog")
	public String ToLoginlog() {
		return "loginlog";
	}

	@RequestMapping(value = "/setting")
	public String ToSetting() {
		return "setting";
	}

	@RequestMapping(value = "/readset")
	public String ToReadset() {
		return "readset";
	}

	@RequestMapping(value = "/addArticle.do")
	public String ToAddArticle() {
		return "add-article";
	}

	@RequestMapping(value = "/addFlink.do")
	public String ToAddFlink() {
		return "add-flink";
	}
}
