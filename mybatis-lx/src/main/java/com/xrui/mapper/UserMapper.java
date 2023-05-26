package com.xrui.mapper;

import com.xrui.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author NXRUI
 * @version 1.0.0
 * @description TODO
 * @date 2023/5/17 11:18
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有的信息
     * @return 所有用户对象
     */
    @Select("select * from user")
    public List<User> selUser();
}
