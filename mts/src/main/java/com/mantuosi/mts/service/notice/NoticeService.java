package com.mantuosi.mts.service.notice;

import com.mantuosi.mts.core.bean.notice.Notice;

import cn.itcast.common.page.Pagination;

public interface NoticeService {

	Pagination selectPaginationByQuery(Integer pageNo);

	void deleteNoticeByPrimaryKey(Integer id);

	void insertNotice(Notice notice);

	Notice selectByPrimaryKey(Integer id);

}
