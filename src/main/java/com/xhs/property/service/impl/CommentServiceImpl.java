package com.xhs.property.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhs.property.mapper.CommentMapper;
import com.xhs.property.mapper.PropertyMapper;
import com.xhs.property.mapper.UserMapper;
import com.xhs.property.pojo.Comment;
import com.xhs.property.pojo.User;
import com.xhs.property.service.CommentService;
import com.xhs.property.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    public Comment selectById(int commentId) {
        return commentMapper.selectByPrimaryKey(commentId);
    }

    public int update(Comment comment) {
        return commentMapper.updateByPrimaryKey(comment);
    }
}
