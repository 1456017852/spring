package com.naruto.day03.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSeleter implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        String [] StringArray=new String[]{"com.naruto.day03.bean.Block"};

        return StringArray;
        }
}
