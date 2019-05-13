package com.naruto.day03.config;

import com.naruto.day03.bean.Green;
import com.naruto.day03.bean.Yellow;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ Yellow.class, Green.class,MyImportSeleter.class,MyImportBeanDefinitionRegistrar.class}) //导入组件
public class ImportJavaConfig {

}
