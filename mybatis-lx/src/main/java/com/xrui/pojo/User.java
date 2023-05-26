package com.xrui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author NXRUI
 * @version 1.0.0
 * @description TODO
 * @date 2023/5/17 11:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private short age;
    /**
     * 性别
     */
    private short gender;
    /**
     * 电话
     */
    private String phone;

}
