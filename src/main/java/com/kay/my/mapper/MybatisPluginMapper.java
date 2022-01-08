package com.kay.my.mapper;


import com.kay.my.entity.MybatisPlugin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface MybatisPluginMapper {
    List<MybatisPlugin> getById(int id);
}
