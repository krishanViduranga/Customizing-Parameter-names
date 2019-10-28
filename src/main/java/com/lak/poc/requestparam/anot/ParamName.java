package com.lak.poc.requestparam.anot;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamName {

    /**
     * The name of the request parameter to bind to.
     */
    String value();
}
