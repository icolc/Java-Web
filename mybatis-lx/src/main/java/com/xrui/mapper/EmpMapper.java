package com.xrui.mapper;

import com.xrui.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author NXRUI
 * @version 1.0.0
 * @description TODO
 * @date 2023/5/17 14:42
 */
@Mapper
public interface EmpMapper {
    /**
     * 新增员工用户
     * @param emp
     */
    void insert(Emp emp);

    void delete(String id);

    void update(Emp emp);

    List<Emp> listEmp();

    Emp select(String id);
}
