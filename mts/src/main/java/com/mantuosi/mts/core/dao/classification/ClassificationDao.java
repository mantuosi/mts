package com.mantuosi.mts.core.dao.classification;

import com.mantuosi.mts.core.bean.classification.Classification;
import com.mantuosi.mts.core.bean.classification.ClassificationQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassificationDao {
    int countByExample(ClassificationQuery example);

    int deleteByExample(ClassificationQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Classification record);

    int insertSelective(Classification record);

    List<Classification> selectByExample(ClassificationQuery example);

    Classification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Classification record, @Param("example") ClassificationQuery example);

    int updateByExample(@Param("record") Classification record, @Param("example") ClassificationQuery example);

    int updateByPrimaryKeySelective(Classification record);

    int updateByPrimaryKey(Classification record);
}