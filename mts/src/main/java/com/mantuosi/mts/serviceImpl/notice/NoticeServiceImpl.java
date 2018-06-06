package com.mantuosi.mts.serviceImpl.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantuosi.mts.core.bean.notice.Notice;
import com.mantuosi.mts.core.bean.notice.NoticeQuery;
import com.mantuosi.mts.core.dao.notice.NoticeDao;
import com.mantuosi.mts.service.notice.NoticeService;

import cn.itcast.common.page.Pagination;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	public Pagination selectPaginationByQuery(Integer pageNo) {
		NoticeQuery noticeQuery = new NoticeQuery();
		noticeQuery.setPageNo(Pagination.cpn(pageNo));
		noticeQuery.setPageSize(8);
		noticeQuery.setOrderByClause("id desc");

		StringBuilder params = new StringBuilder();
		Pagination pagination = new Pagination(noticeQuery.getPageNo(), noticeQuery.getPageSize(),
				noticeDao.countByExample(noticeQuery));
		List<Notice> noticeList = noticeDao.selectByExample(noticeQuery);
		pagination.setList(noticeList);
		String url = "/notice";
		pagination.pageView(url, params.toString());
		return pagination;
	}

	public void deleteNoticeByPrimaryKey(Integer id) {
		noticeDao.deleteByPrimaryKey(id);
	}

	public void insertNotice(Notice notice) {
		noticeDao.insertSelective(notice);
	}

	public Notice selectByPrimaryKey(Integer id) {
		return noticeDao.selectByPrimaryKey(id);
	}
}
