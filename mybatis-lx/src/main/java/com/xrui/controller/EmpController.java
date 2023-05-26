package com.xrui.controller;

import com.xrui.pojo.Emp;
import com.xrui.pojo.Result;
import com.xrui.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * EmpController
 *
 * @author liliudong
 * @version 1.0
 * @description 员工信息Controller
 * @date 2023/5/20 18:13
 */
@RestController
public class EmpController {
    //私有service层
    @Autowired
    private EmpService empService;

    /**
     * 添加员工信息
     * @param emp 需要添加的员工信息
     * @return
     */
    @RequestMapping("/add")
    public Result addUser(@RequestBody Emp emp) {
        empService.addUser(emp);
        return Result.success();
    }

    /**
     * 根据ID删除员工信息
     *
     * @param id 需要删除的员工ID
     * @return
     */
    @RequestMapping("/del/{id}")
    public Result deleteById(@PathVariable String id) {
        // TODO UserService.xxxx
        empService.deleteById(id);
        return Result.success();
    }

    /**
     * 根据ID更新员工信息
     *
     * @param emp 员工信息
     * @return
     */
    @RequestMapping("/updateById")
    public Result updateById(@RequestBody Emp emp) {
        // TODO UserService.xxxx
        empService.updateById(emp);
        return Result.success();

    }

    /**
     * 获取员工信息列表
     *
     * @return 员工列表
     */
    @RequestMapping("/list")
    public Result list() {
        // TODO UserService.xxxx
        List<Emp> list = empService.list();
        return Result.success(list);
    }

    /**
     * 根据ID获取员工信息
     *
     * @param id 员工ID
     * @return 员工信息
     */
    @RequestMapping("/info/{id}")
    public Result infoById(@PathVariable String id) {
        // TODO UserService.xxxx
        Emp emp =empService.infoById(id);
        return Result.success(emp);

    }
}

