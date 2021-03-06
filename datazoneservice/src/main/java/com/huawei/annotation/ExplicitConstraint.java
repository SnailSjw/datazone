package com.huawei.annotation;

import java.lang.annotation.*;

/**
 * 字段显示约束
 * @author majiwei
 * @since 2020/6/8
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface ExplicitConstraint {
    // 定义固定下拉内容
    String[] dropDowns()default {};
}
