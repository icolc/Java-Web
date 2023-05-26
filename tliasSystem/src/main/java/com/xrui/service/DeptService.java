package com.xrui.service;

import com.xrui.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有部门数据
     * @return
     */
    List<Dept> selectAllDept();

    /**
     * 根据id删除部门
     * @param id
     */
    void deleteDeptById(Integer id);

    /**
     * 新增部门
     * @param dept  要新增的部门
     */
    void addDept(Dept dept);
}
