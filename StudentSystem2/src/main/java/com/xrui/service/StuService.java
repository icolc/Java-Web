package com.xrui.service;

import com.xrui.pojo.Student;


public interface StuService {
    /**
     * 注册方法
     *
     * @param student 要注册的学生信息
     * @return 注册的信息
     */
    Student registerStu(Student student);

    /**
     * 登录方法
     * @param student 要登录的学生对象
     * @return 返回学生对象 or null
     */
    Student login(Student student);

    /**
     * 根据用户名查询学生
     * @param username 用户名
     * @return 学生对象
     */
    Student selectStuByName(String username);

    /**
     * 根据用户名删除学生
     * @param username 要删除的用户名
     */
    void delStuByName(String username);
}
