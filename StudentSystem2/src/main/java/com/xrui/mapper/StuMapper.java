package com.xrui.mapper;

import com.xrui.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuMapper {

    Student select(String username);

    void insert(Student student);

    void deleteStuByName(String username);
}
