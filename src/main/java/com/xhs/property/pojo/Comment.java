package com.xhs.property.pojo;

public class Comment {
    private Integer commentId;

    private Integer propertyContentId;

    private String content;

    private Integer userId;

    private Integer praiseCount;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPropertyContentId() {
        return propertyContentId;
    }

    public void setPropertyContentId(Integer propertyContentId) {
        this.propertyContentId = propertyContentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }
}