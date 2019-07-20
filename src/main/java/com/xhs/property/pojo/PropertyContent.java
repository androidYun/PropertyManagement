package com.xhs.property.pojo;

import java.util.Date;
import java.util.List;

public class PropertyContent {
    private Integer propertyContentId;

    private Integer propertyId;

    private String goodContent;

    private String badContent;

    private Integer score;

    private Integer state;

    private String failPassReason;

    private Date createTime;

    private int userId;

    private List<String> imagesList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getPropertyContentId() {
        return propertyContentId;
    }

    public void setPropertyContentId(Integer propertyContentId) {
        this.propertyContentId = propertyContentId;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getGoodContent() {
        return goodContent;
    }

    public void setGoodContent(String goodContent) {
        this.goodContent = goodContent;
    }

    public String getBadContent() {
        return badContent;
    }

    public void setBadContent(String badContent) {
        this.badContent = badContent == null ? null : badContent.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFailPassReason() {
        return failPassReason;
    }

    public void setFailPassReason(String failPassReason) {
        this.failPassReason = failPassReason == null ? null : failPassReason.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<String> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }
}