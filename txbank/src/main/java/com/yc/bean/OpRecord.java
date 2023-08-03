package com.yc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor //带所有参数的构造方法
@NoArgsConstructor //无参
@ToString //生成tostring
public class OpRecord {
    private int id;
    private int accountid;
    private double opmoney;
    private String optime;
    private OpType opType;
    private Integer transferid;
}
