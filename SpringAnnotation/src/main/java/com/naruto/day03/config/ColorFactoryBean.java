package com.naruto.day03.config;

import com.naruto.day03.bean.Green;
import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean {

    public Object getObject() throws Exception {
        return new Green();
    }

    public Class<?> getObjectType() {
        return Green.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
