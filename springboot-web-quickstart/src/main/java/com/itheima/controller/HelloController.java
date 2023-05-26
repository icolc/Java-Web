package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.pojo.User2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 请求处理类
 *
 * @author NXRUI
 */
@Controller
public class HelloController {
    /**
     * 接受普通字符
     */
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello World~");
        return "Hello World~";
    }

    /**
     * 接受多个字符
     */
    @RequestMapping("/hello2")
    public String hello2(@RequestParam(name = "name") String username, Integer age) {
        System.out.println("Hello World2~");
        System.out.println(username + ":" + age);
        return "ok~";
    }

    /**
     * 简单实例
     */
    @RequestMapping("/simplePojo")
    public String simpleUserPojo(User user) {
        System.out.println(user);
        return "ok~";
    }

    /**
     * 复杂实例
     */
    @RequestMapping("/simplePojo2")
    public String simpleUser2Pojo(User2 user) {
        System.out.println(user);
        return "ok~";
    }

    /**
     * 数组实例
     */
    @RequestMapping("/simplePojo3")
    public String simpleUser3Pojo(@RequestParam List<User> user) {
        System.out.println(user);
        return "ok~";
    }

    /**
     * 集合实例
     */
    @RequestMapping("/simplePojo4")
    public String simpleUser4Pojo(@RequestParam List<User2> user) {
        System.out.println(user);
        return "ok~";
    }

    /**
     * 时间实例
     */
    @RequestMapping("/simplePojo5")
    public String simpleUser5Pojo(
            @RequestParam("nowTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime time) {
        System.out.println(time);
        return "ok~";
    }

    /**
     * json实例
     */
    @PostMapping("/simplePojo6")
    public String simpleUser6Pojo(@RequestBody User2 user) {
        System.out.println(user);
        return "ok~";
    }

    /**
     * 路径参数
     */
    @RequestMapping("/simplePojo7/{id}/{name}")
    public String simpleUser7Pojo(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id + "==>"+ name);
        return "ok~";
    }
}
