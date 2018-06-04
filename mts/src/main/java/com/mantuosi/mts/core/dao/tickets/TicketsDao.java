package com.mantuosi.mts.core.dao.tickets;

import com.mantuosi.mts.core.bean.tickets.Tickets;
import com.mantuosi.mts.core.bean.tickets.TicketsQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketsDao {
    int countByExample(TicketsQuery example);

    int deleteByExample(TicketsQuery example);

    int deleteByPrimaryKey(String tid);

    int insert(Tickets record);

    int insertSelective(Tickets record);

    List<Tickets> selectByExample(TicketsQuery example);

    Tickets selectByPrimaryKey(String tid);

    int updateByExampleSelective(@Param("record") Tickets record, @Param("example") TicketsQuery example);

    int updateByExample(@Param("record") Tickets record, @Param("example") TicketsQuery example);

    int updateByPrimaryKeySelective(Tickets record);

    int updateByPrimaryKey(Tickets record);
}