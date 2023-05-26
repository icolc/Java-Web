package com.xrui.service.impl;

import com.xrui.mapper.EmpMapper;
import com.xrui.pojo.Emp;
import com.xrui.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    //私有Mapper接口
    @Autowired
    private EmpMapper empMapper;

    /**
     * 添加员工方法
     * @param emp
     */
    @Override
    public void addUser(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void deleteById(String id) {
        empMapper.delete(id);
    }

    /**
     * 更新用户
     *
     * @param emp
     */
    @Override
    public void updateById(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    /**
     * 获取员工列表
     */
    @Override
    public List<Emp> list() {
        return empMapper.listEmp();
    }

    /**
     * 根据员工获取其他信息
     *
     * @param id
     * @return
     */
    @Override
    public Emp infoById(String id) {
        return empMapper.select(id);
    }
}
