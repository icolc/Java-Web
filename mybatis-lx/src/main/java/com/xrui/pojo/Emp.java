package com.xrui.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author NXRUI
 * @version 1.0.0
 * @description TODO
 * @date 2023/5/17 14:43
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别 1，男 2 女
     */
    private Short gender;
    /** 头像 */
    private String image;
    /**
     * 职称
     */
    private Short job;
    /**
     * 入职日期
     */
    private LocalDate entrydate;
    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
