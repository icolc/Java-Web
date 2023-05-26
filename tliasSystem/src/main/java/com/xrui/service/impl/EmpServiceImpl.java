package com.xrui.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xrui.mapper.EmpMapper;
import com.xrui.pojo.Emp;
import com.xrui.pojo.PageBean;
import com.xrui.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageBean service(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);

        //执行查询
        List<Emp> list = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) list;

        //封装bean对象
        return new PageBean(p.getTotal(), p.getResult());
    }

    /**
     * 根据ID批量删除用户
     *
     * @param ids
     */
    @Override
    public void delById(List<Integer> ids) {
        empMapper.delete(ids);
    }

    /**
     * 添加员工
     *
     * @param emp 要添加的员工
     */
    @Override
    public void addEmp(Emp emp) {
        //给这个emp添加属性
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    /**
     * 根据ID查询员工
     * @param id id
     * @return 返回查询到的员工
     */
    @Override
    public Emp getById(Integer id) {
        return empMapper.getByID(id);
    }
    /**
     * 修改员工
     *
     * @param emp
     */
    @Override
    public void updateById(Emp emp) {
        //修改属性
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    /**
     * 登录
     *
     * @param username 名字
     * @param password 密码
     * @return
     */
    @Override
    public Emp selectByNamePassword(Emp emp) {
        return empMapper.selectByNamePassword(emp);
    }


}
