package com.xrui.controller;

import com.xrui.pojo.Emp;
import com.xrui.pojo.Result;
import com.xrui.service.EmpService;
import com.xrui.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NXRUI
 * @version 1.0
 * @date 2023/5/23 9:41
 * @description:
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private EmpService service;

    private static final String USER_PASSWORD_EXCEPTION = "用户名或密码错误！";

    /**
     * 登录页面的方法
     */
    @PostMapping ("/login")
    private Result login(@RequestBody Emp emp){
        log.info("员工登录中。。。用户名：{}，密码：{}",emp.getUsername(),emp.getPassword());
        Emp p =service.selectByNamePassword(emp);

        //登录成功
        if (p != null){
            Map<String, Object> clamis = new HashMap<>();
            clamis.put("id",p.getId());
            clamis.put("username",p.getUsername());
            clamis.put("name",p.getName());
            String jwt = JwtUtils.generateJwt(clamis);
            log.info("JWT令牌为:{}",jwt);
            return Result.success(jwt);
        }

        //登录失败
        return Result.error(USER_PASSWORD_EXCEPTION);
    }
}
