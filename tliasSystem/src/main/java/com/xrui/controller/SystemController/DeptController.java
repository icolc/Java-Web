package com.xrui.controller.SystemController;

import com.xrui.pojo.Dept;
import com.xrui.pojo.Result;
import com.xrui.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    /**
     * 私有化service层
     */
    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门
     * @return 返回响应数据
     */
    @GetMapping
    private Result selectAllDept() {
        log.info("查询所有部门中...");
        //调用service层查询所有方法
        List<Dept> deptList = deptService.selectAllDept();
        return Result.success(deptList);
    }

    /**
     * 根据id删除
     */
    @DeleteMapping("/{id}")
    private Result deleteDeptById(@PathVariable Integer id){
        log.info("删除部门信息中.... : {}",id);
        //调用service层中删除部门的方法
        deptService.deleteDeptById(id);
        return Result.success();
    }

    /**
     * 添加部门的方法
     */
    @PostMapping
    private Result addDept(@RequestBody Dept dept){
        log.info("新增部门中...:{}",dept);
        //调用service层的add方法
        deptService.addDept(dept);
        return Result.success();
    }
}
