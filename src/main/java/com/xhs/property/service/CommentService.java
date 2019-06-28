package com.xhs.property.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhs.property.pojo.Comment;
import com.xhs.property.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface CommentService extends IService<Comment> {
    Comment selectById(int commentId);

    int update(Comment comment);
}
