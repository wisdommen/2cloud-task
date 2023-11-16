package com.wisdommee.cloud2.entity.bo;

public enum CompareType {
    EQUALS("equals"),
    LIKE("like"),
    GT("gt"),
    LT("lt"),
    GTE("gte"),
    LTE("lte");

    private final String type;

    CompareType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
