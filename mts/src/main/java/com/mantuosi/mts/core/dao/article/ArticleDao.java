package com.mantuosi.mts.core.dao.article;

import com.mantuosi.mts.core.bean.article.Article;
import com.mantuosi.mts.core.bean.article.ArticleQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleDao {
    int countByExample(ArticleQuery example);

    int deleteByExample(ArticleQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleQuery example);

    Article selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleQuery example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleQuery example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}