package com.xrui.service;

import com.xrui.exception.UserNameException;
import com.xrui.exception.UserPassWordNotException;
import com.xrui.mapper.StuMapper;
import com.xrui.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements StuService {

    /**
     * 私有化mapper
     */
    private final StuMapper stuMapper;

    @Autowired
    public StuServiceImpl(StuMapper stuMapper) {
        this.stuMapper = stuMapper;
    }

    /**
     * 根据学生对象返回学生对象名
     */
    private String getStuName(Student student) {
        return student.getUsername();
    }

    /**
     * 判断返回的学生是不是null
     */
    private Student IsEmpty(Student student) {
        if (student == null) {
            throw new UserNameException();
        } else {
            return student;
        }
    }

    /**
     * 注册方法
     *
     * @param student 要注册的学生信息
     * @return
     */
    @Override
    public Student registerStu(Student student) {
        //调用getStuName方法
        String username = getStuName(student);
        //调用mapper查询方法
        Student select = stuMapper.select(username);
        //判断是否为null
        if (select == null) {
            //调用mapper新增方法
            stuMapper.insert(student);
            return student;
        } else {
            //抛出异常
            throw new UserNameException("用户名不存在");
        }
    }

    /**
     * 登录方法
     *
     * @param student 要登录的学生对象
     */
    @Override
    public Student login(Student student) {
        //先查,调用getStuName方法
        String stuName = getStuName(student);
        Student select = stuMapper.select(stuName);
        if (select == null) {
            throw new UserNameException();
        } else {
            //判断密码是否正确
            if (select.getPassword().equals(student.getPassword())){
                return select;
            }
            throw new UserPassWordNotException();
        }


    }

    /**
     * 根据用户名查询学生
     *
     * @param username 用户名
     * @return 学生对象
     */
    @Override
    public Student selectStuByName(String username) {
        //调用mapper层的查询方法
        Student select = stuMapper.select(username);
        return IsEmpty(select);
    }

    /**
     * 根据用户名删除学生
     *
     * @param username 要删除的用户名
     */
    @Override
    public void delStuByName(String username) {
        //调用mapper层的查询方法
        Student select = stuMapper.select(username);
        if (select == null) {
            throw new UserNameException();
        } else {
            //调用mapper层的删除方法
            stuMapper.deleteStuByName(username);
        }
    }
}
