package com.mantuosi.mts.core.dao.category;

import com.mantuosi.mts.core.bean.category.Category;
import com.mantuosi.mts.core.bean.category.CategoryQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryDao {
    int countByExample(CategoryQuery example);

    int deleteByExample(CategoryQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryQuery example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryQuery example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryQuery example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}