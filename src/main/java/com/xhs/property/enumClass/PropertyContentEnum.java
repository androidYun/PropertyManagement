package com.xhs.property.enumClass;

public enum PropertyContentEnum {
    wait_review("待审核", 0),
    review_pass("审核通过", 1),
    not_pass("未审核通过", 2);

    private String type;

    private int state;
    PropertyContentEnum(String type, int state) {
        this.type = type;
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
