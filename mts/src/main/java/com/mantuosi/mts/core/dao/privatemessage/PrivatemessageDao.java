package com.mantuosi.mts.core.dao.privatemessage;

import com.mantuosi.mts.core.bean.privatemessage.Privatemessage;
import com.mantuosi.mts.core.bean.privatemessage.PrivatemessageQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivatemessageDao {
    int countByExample(PrivatemessageQuery example);

    int deleteByExample(PrivatemessageQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Privatemessage record);

    int insertSelective(Privatemessage record);

    List<Privatemessage> selectByExampleWithBLOBs(PrivatemessageQuery example);

    List<Privatemessage> selectByExample(PrivatemessageQuery example);

    Privatemessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Privatemessage record, @Param("example") PrivatemessageQuery example);

    int updateByExampleWithBLOBs(@Param("record") Privatemessage record, @Param("example") PrivatemessageQuery example);

    int updateByExample(@Param("record") Privatemessage record, @Param("example") PrivatemessageQuery example);

    int updateByPrimaryKeySelective(Privatemessage record);

    int updateByPrimaryKeyWithBLOBs(Privatemessage record);

    int updateByPrimaryKey(Privatemessage record);
}