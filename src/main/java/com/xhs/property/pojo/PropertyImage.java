package com.xhs.property.pojo;

public class PropertyImage {
    private Integer imageId;

    private Integer propertyContentId;

    private String url;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getPropertyContentId() {
        return propertyContentId;
    }

    public void setPropertyContentId(Integer propertyContentId) {
        this.propertyContentId = propertyContentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}