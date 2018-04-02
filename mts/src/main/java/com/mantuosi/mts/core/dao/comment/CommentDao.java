package com.mantuosi.mts.core.dao.comment;

import com.mantuosi.mts.core.bean.comment.Comment;
import com.mantuosi.mts.core.bean.comment.CommentQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentDao {
    int countByExample(CommentQuery example);

    int deleteByExample(CommentQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExampleWithBLOBs(CommentQuery example);

    List<Comment> selectByExample(CommentQuery example);

    Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByExampleWithBLOBs(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentQuery example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}