package com.library.devpulse.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//method starting time profiled

@Retention(RetentionPolicy.RUNTIME) //런타임 시 유지되는 어노테이션
@Target(ElementType.METHOD) // 메서드에만 사용 가능
public @interface Profiled {
    String[] value() default "";  //부가적인 설명 (옵션)
}
