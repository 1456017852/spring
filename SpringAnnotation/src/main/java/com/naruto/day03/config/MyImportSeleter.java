package com.naruto.day03.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * AnnotationMetadata:当前配置类的注解元信息
 */
public class MyImportSeleter implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        String [] StringArray=new String[]{"com.naruto.day03.bean.Block"};

        return StringArray;
        }
}
