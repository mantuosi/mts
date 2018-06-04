package com.mantuosi.mts.serviceImpl.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantuosi.mts.core.bean.tickets.TicketsQuery;
import com.mantuosi.mts.core.bean.tickets.TicketsQuery.Criteria;
import com.mantuosi.mts.core.dao.tickets.TicketsDao;
import com.mantuosi.mts.service.tickets.TicketsService;

import cn.itcast.common.page.Pagination;

@Service("TicketService")
public class TicketsServiceImpl implements TicketsService {
	@Autowired
	private TicketsDao ticketsDao;

	public Pagination selectPaginationByQuery(Integer pageNo) {
		TicketsQuery ticketsQuery = new TicketsQuery();
		ticketsQuery.setPageNo(Pagination.cpn(pageNo));
		ticketsQuery.setPageSize(2);
		ticketsQuery.setOrderByClause("tid asc");
		// Criteria criteria = articleQuery.createCriteria();
		StringBuilder params = new StringBuilder();
		Pagination pagination = new Pagination(ticketsQuery.getPageNo(), ticketsQuery.getPageSize(),
				ticketsDao.countByExample(ticketsQuery));
		pagination.setList(ticketsDao.selectByExample(ticketsQuery));
		String url = "/all";
		pagination.pageView(url, params.toString());
		return pagination;

	}

	public Pagination selectPaginationByQueryAddress(Integer pageNo) {
		TicketsQuery ticketsQuery = new TicketsQuery();
		ticketsQuery.setPageNo(Pagination.cpn(pageNo));
		ticketsQuery.setPageSize(2);
		ticketsQuery.setOrderByClause("tid asc");
		Criteria criteria = ticketsQuery.createCriteria();
		StringBuilder params = new StringBuilder();
		criteria.andDestinationAddEqualTo("DAM");
		params.append("destination_add 	=").append("DAM");
		Pagination pagination = new Pagination(ticketsQuery.getPageNo(), ticketsQuery.getPageSize(),
				ticketsDao.countByExample(ticketsQuery));
		pagination.setList(ticketsDao.selectByExample(ticketsQuery));
		String url = "/dam";
		pagination.pageView(url, params.toString());
		return pagination;
	}

	public Pagination selectPaginationByQueryUserAndAddress(Integer pageNo) {
		TicketsQuery ticketsQuery = new TicketsQuery();
		ticketsQuery.setPageNo(Pagination.cpn(pageNo));
		ticketsQuery.setPageSize(9);
		ticketsQuery.setOrderByClause("tid asc");
		Criteria criteria = ticketsQuery.createCriteria();
		StringBuilder params = new StringBuilder();
		criteria.andDestinationAddEqualTo("DAM");
		params.append("destination_add 	=").append("DAM");
		Pagination pagination = new Pagination(ticketsQuery.getPageNo(), ticketsQuery.getPageSize(),
				ticketsDao.countByExample(ticketsQuery));
		pagination.setList(ticketsDao.selectByExample(ticketsQuery));
		String url = "/userList";
		pagination.pageView(url, params.toString());
		return pagination;
	}
}
