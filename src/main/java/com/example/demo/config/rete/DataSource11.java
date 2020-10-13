package com.example.demo.config.rete;

import java.lang.annotation.*;

//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
//@Documented

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSource11 {
    String value() default "datasource1";
}
