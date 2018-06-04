package com.mantuosi.mts.service.tickets;

import cn.itcast.common.page.Pagination;

public interface TicketsService {

	Pagination selectPaginationByQuery(Integer pageNo);

	Pagination selectPaginationByQueryAddress(Integer pageNo);

	Pagination selectPaginationByQueryUserAndAddress(Integer pageNo);

}
