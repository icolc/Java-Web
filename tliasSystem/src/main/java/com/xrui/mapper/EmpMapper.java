package com.xrui.mapper;

import com.xrui.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 员工所有查询
     * @return
     */
    List<Emp> list(String name , Short gender , LocalDate begin , LocalDate end);

    /**
     * 根据ID批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加员工的方法
     * @param emp 要添加的emp
     */
    void insert(Emp emp);

    @Select("select * from emp where id= #{id}")
    Emp getByID(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    Emp selectByNamePassword(Emp emp);

    /**
     * 根据部门id删除
     * @param id
     */
    void deleteByDetpId(Integer id);
}
