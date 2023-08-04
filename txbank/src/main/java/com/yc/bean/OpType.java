package com.yc.bean;


//枚举  enum
public enum  OpType {
    WITHDRAW("withdraw",1), //取
    DEPOSITE("deposite",2),  //存
    TRANSFER("transfer",3) ;  //转
    private String key;
    private int value;

    OpType(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
