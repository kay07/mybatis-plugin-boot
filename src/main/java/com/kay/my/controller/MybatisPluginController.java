package com.kay.my.controller;

import com.kay.my.service.MybatisPluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MybatisPluginController {
    @Autowired
    private MybatisPluginService mybatisPluginService;
    @RequestMapping(value = "/d",method = RequestMethod.GET)
    public void getById(@RequestParam(value = "id")int id){
        mybatisPluginService.getById(id);
    }
}
