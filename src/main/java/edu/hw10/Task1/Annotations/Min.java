package edu.hw10.Task1.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target(ElementType.PARAMETER)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Min {
    int intValue() default 50;
}
