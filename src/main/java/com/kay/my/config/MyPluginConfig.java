package com.kay.my.config;

import com.kay.my.plugin.MyPlugin;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnBean({SqlSessionFactory.class})
public class MyPluginConfig {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Bean
    public void myInterceptor(){
        sqlSessionFactory.getConfiguration().addInterceptor(new MyPlugin());
    }
}
