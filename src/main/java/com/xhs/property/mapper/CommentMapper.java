package com.xhs.property.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xhs.property.pojo.Comment;

public interface CommentMapper extends BaseMapper<Comment> {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}