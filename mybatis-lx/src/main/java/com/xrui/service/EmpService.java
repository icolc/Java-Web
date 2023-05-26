package com.xrui.service;

import com.xrui.pojo.Emp;

import java.util.List;

public interface EmpService {
    /**
     * 添加员工方法
     * @param emp
     */
    void addUser(Emp emp);

    /**
     * 删除用户
     * @param id
     */
    void deleteById(String id);

    /**
     * 更新用户
     * @param emp
     */
    void updateById(Emp emp);

    /**
     * 获取员工列表
     */
    List<Emp> list();

    /**
     * 根据员工获取其他信息
     *
     * @param id
     * @return
     */
    Emp infoById(String id);
}
