package com.xrui.controller;

import com.xrui.exception.UserNameException;
import com.xrui.exception.UserPassWordNotException;
import com.xrui.pojo.Student;
import com.xrui.service.StuService;
import com.xrui.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class StuController {
    /**
     * 常量
     */
    private static final String ERROR_MSG_USER_EXISTS = "用户已存在!";
    private static final String ERROR_MSG_PASSWORD_ILLEGAL = "密码不符合规范!";
    private static final String ERROR_MSG_USER_NOT_EXISTS = "用户不存在!";


    /**
     * 隐藏密码
     */
    private static final String PASS_WORD = "******";

    /**
     * 私有service层
     */
    private StuService stuService;

    public StuController(StuService stuService) {
        this.stuService = stuService;
    }

    /**
     * 注册
     * @param student 传进来的student对象
     */
    @RequestMapping("/register")
    private Result register(@RequestBody Student student) {
        //调用service层的注册用户方法
        try {
            Student student1 = stuService.registerStu(student);
            student1.setPassword(PASS_WORD);
            return Result.success(student1);
        } catch (Exception e) {
            return Result.error(ERROR_MSG_USER_EXISTS);
        }
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    private Result login(@RequestBody Student student) {
        //调用service层的登录方法
        try {
            Student student1 = stuService.login(student);
            student1.setPassword(PASS_WORD);
            return Result.success(student1);
        } catch (UserNameException e) {
            return Result.error(ERROR_MSG_USER_NOT_EXISTS);
        }catch (UserPassWordNotException e){
            return Result.error(ERROR_MSG_PASSWORD_ERROR);
        }
    }

    /**
     * 根据用户名查询信息
     */
    @RequestMapping("/{username}")
    private Result selectStuByName(@PathVariable String username) {
        //调用service层的查询方法
        try {
            Student student = stuService.selectStuByName(username);
            return Result.success(student);
        } catch (Exception e) {
            return Result.error(ERROR_MSG_USER_NOT_EXISTS);
        }
    }

    /**
     * 根据用户名删除学生
     */
    @RequestMapping("/del")
    private Result delStuByName(String username) {
        //调用service层的删除方法
        try {
            stuService.delStuByName(username);
            return Result.success();
        } catch (Exception e) {
            return Result.error(ERROR_MSG_USER_NOT_EXISTS);
        }
    }
}
