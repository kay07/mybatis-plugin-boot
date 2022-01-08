package com.kay.my.service;

import com.kay.my.entity.MybatisPlugin;
import com.kay.my.mapper.MybatisPluginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybatisPluginService {
    @Autowired
    private MybatisPluginMapper mybatisPluginMapper;
    public void getById(int id){
        List<MybatisPlugin> byId = mybatisPluginMapper.getById(id);
        System.out.println(byId);
    }
}
