package com.example.demo.config;

public class DataSourceContextHolder {
    //默认的数据源
    public static final String DEFAULT_DB = "datasource1";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    //设置数据源
    public static void setDB(String dbType){
        System.out.println("切换到---" + dbType + "---数据源");
        contextHolder.set(dbType);
    }

    //获取数据源
    public static String getDB(){
        return (contextHolder.get());
    }

    //清除数据源
    public static void clearDB(){
        contextHolder.remove();
    }
}
