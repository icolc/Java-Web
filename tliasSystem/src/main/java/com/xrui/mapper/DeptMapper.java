package com.xrui.mapper;

import com.xrui.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有部门
     */
    @Select("select * from dept;")
    List<Dept> selectAllDept();

    /**
     * 删除部门
     * @param id    要删除的id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteDeptById(Integer id);

    @Insert("insert into dept (name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void addDept(Dept dept);
}
