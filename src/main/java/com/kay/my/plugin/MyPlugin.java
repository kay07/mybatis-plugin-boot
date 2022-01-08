package com.kay.my.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@Intercepts({@Signature(type = StatementHandler.class,method = "parameterize",args = java.sql.Statement.class)})
public class MyPlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyPlugin---->intercept---->getMethod"+invocation.getMethod());
        System.out.println("MyPlugin---->intercept---->getTarget"+invocation.getTarget());
        System.out.println("MyPlugin---->intercept---->getArgs"+invocation.getArgs());
        Object target = invocation.getTarget();
        //拿到：StatementHandler==>ParameterHandler===>parameterObject
        //拿到target的元数据.
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        Object sql = metaObject.getValue("parameterHandler.boundSql.sql");
        System.out.println("sql语句的参数是 "+value);
        System.out.println("sql-----"+sql);
        //修改sql参数为2
        metaObject.setValue("parameterHandler.parameterObject",2);
        //执行目标方法
        Object proceed = invocation.proceed();
        return proceed;
    }
    //包装目标对象，为目标对象创建代理对象
    public Object plugin(Object target) {
        //我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们目标对象
        System.out.println("MyFirstPlugin...plugin:mybatis将要包装的对象"+target);
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }
    //将插件注册时 的property属性设置进来
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息："+properties);
    }
}
