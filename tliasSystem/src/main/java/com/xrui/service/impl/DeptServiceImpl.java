package com.xrui.service.impl;

import com.xrui.mapper.DeptMapper;
import com.xrui.mapper.EmpMapper;
import com.xrui.pojo.Dept;
import com.xrui.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    /**
     * 私有mapper层
     */
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    /**
     * 查询所有部门数据
     * @return
     */
    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }

    /**
     * 根据id删除部门
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDeptById(Integer id) {
        //调用mapper接口的方法
        deptMapper.deleteDeptById(id);
        //模拟异常
        int i = 1/0;
        //调用empMapper接口的删除方法
        empMapper.deleteByDetpId(id);
    }

    /**
     * 新增部门
     *
     * @param dept 要新增的部门
     */
    @Override
    public void addDept(Dept dept) {
        //添加属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用mapper接口的add方法
        deptMapper.addDept(dept);
    }
}
