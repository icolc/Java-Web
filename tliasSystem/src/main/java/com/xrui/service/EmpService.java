package com.xrui.service;

import com.xrui.pojo.Emp;
import com.xrui.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean service(Integer page, Integer pageSize, String name , Short gender , LocalDate begin , LocalDate end);

    /**
     * 根据ID批量删除记录
     * @param ids
     */
    void delById(List<Integer> ids);

    /**
     * 添加员工
     * @param emp 要添加的员工
     */
    void addEmp(Emp emp);

    /**
     * 根据ID查询员工
     * @param id id
     * @return 返回员工
     */
    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void updateById(Emp emp);

    /**
     * 登录方法
     *
     * @param username 名字
     * @param password 密码
     * @return
     */
    Emp selectByNamePassword(Emp emp);
}
