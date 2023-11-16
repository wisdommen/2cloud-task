package com.wisdommee.cloud2.annotation;

import com.wisdommee.cloud2.entity.bo.CompareType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SearchField {
    String value();

    CompareType type() default CompareType.EQUALS;
}
