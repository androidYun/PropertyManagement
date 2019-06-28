package com.xhs.property.controller;

import com.xhs.property.pojo.Comment;
import com.xhs.property.pojo.ResultEntity;
import com.xhs.property.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    private ResultEntity addComment(@RequestBody Comment comment) {
        if (comment.getContent() == null) {
            return ResultEntity.getErrorResult("评论内容不能为空");
        }
        comment.setPraiseCount(0);
        boolean isInsert = commentService.save(comment);
        if (isInsert) {
            return ResultEntity.getSuccessResult("请求成功");
        } else {
            return ResultEntity.getErrorResult("插入失败");
        }
    }

    @RequestMapping(value = "/addPraise", method = RequestMethod.GET)
    @ResponseBody
    private ResultEntity addComment(int commentId) {
        Comment comment = commentService.selectById(commentId);
        if (comment == null) {
            return ResultEntity.getErrorResult("评论内容不能为空");
        }
        comment.setPraiseCount(comment.getPraiseCount() + 1);
        commentService.update(comment);
        return ResultEntity.getSuccessResult("点赞成功");
    }
}
