package com.yc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor //带所有参数的构造方法
@NoArgsConstructor //无参
@ToString //生成tostring
public class Account implements Serializable {
    private int accountid;
    private double money;
}
