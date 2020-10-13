package com.example.demo.config.aop;


import com.example.demo.config.DataSourceContextHolder;
import com.example.demo.config.rete.DataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(-10)
//@Order 值越小，优先级越高
public class DynamicDataSourceAspect {
    @SuppressWarnings("rawtypes")
    @Before("@annotation(DataSource)")
    public void before(JoinPoint point){

        //获取当前访问的类名
        Class<?> className = point.getTarget().getClass();

        //获取当前访问的方法名
        String methodName = point.getSignature().getName();

        //获取方法的参数类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();

        //默认数据源
        String dataSource = DataSourceContextHolder.DEFAULT_DB;

        try {
            //获取访问的方法对象
            Method method = className.getMethod(methodName, argClass);
            //判断是否存在@DataSource注解
            if(method.isAnnotationPresent(DataSource.class)){
                DataSource annotation = method.getAnnotation(DataSource.class);
                //获取注解中指定的数据源
                dataSource = annotation.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //切换到指定的数据源
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("@annotation(DataSource)")
    public void after(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
