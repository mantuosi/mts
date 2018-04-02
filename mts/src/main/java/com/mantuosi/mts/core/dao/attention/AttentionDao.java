package com.mantuosi.mts.core.dao.attention;

import com.mantuosi.mts.core.bean.attention.Attention;
import com.mantuosi.mts.core.bean.attention.AttentionQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttentionDao {
    int countByExample(AttentionQuery example);

    int deleteByExample(AttentionQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attention record);

    int insertSelective(Attention record);

    List<Attention> selectByExample(AttentionQuery example);

    Attention selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attention record, @Param("example") AttentionQuery example);

    int updateByExample(@Param("record") Attention record, @Param("example") AttentionQuery example);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}