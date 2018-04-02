package com.mantuosi.mts.core.dao.comment;

import com.mantuosi.mts.core.bean.comment.CommentReply;
import com.mantuosi.mts.core.bean.comment.CommentReplyQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentReplyDao {
    int countByExample(CommentReplyQuery example);

    int deleteByExample(CommentReplyQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentReply record);

    int insertSelective(CommentReply record);

    List<CommentReply> selectByExampleWithBLOBs(CommentReplyQuery example);

    List<CommentReply> selectByExample(CommentReplyQuery example);

    CommentReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentReply record, @Param("example") CommentReplyQuery example);

    int updateByExampleWithBLOBs(@Param("record") CommentReply record, @Param("example") CommentReplyQuery example);

    int updateByExample(@Param("record") CommentReply record, @Param("example") CommentReplyQuery example);

    int updateByPrimaryKeySelective(CommentReply record);

    int updateByPrimaryKeyWithBLOBs(CommentReply record);

    int updateByPrimaryKey(CommentReply record);
}