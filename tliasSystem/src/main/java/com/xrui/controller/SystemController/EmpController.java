package com.xrui.controller.SystemController;

import com.xrui.pojo.Emp;
import com.xrui.pojo.PageBean;
import com.xrui.pojo.Result;
import com.xrui.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     *
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询中,参数:{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        //调用service分页查询
        PageBean pageBean = empService.service(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    /**
     * 根据id批量删除
     */
    @DeleteMapping("/{ids}")
    private Result delById(@PathVariable List<Integer> ids) {
        log.info("批量删除中....ids:{}", ids);
        empService.delById(ids);
        return Result.success();
    }

    /**
     * 添加员工
     */
    @PostMapping
    private Result addEmp(@RequestBody Emp emp) {
        log.info("添加员工中...");
        empService.addEmp(emp);
        return Result.success();
    }


    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    private Result getById(@PathVariable Integer id){
        log.info("根据ID查询员工中，被查询的id为：{}",id);
        Emp byId = empService.getById(id);
        return Result.success(byId);
    }

    /**
     * 修改员工
     */
    @PutMapping
    private Result updateById(@RequestBody Emp emp){
        empService.updateById(emp);
        return Result.success();
    }
}
