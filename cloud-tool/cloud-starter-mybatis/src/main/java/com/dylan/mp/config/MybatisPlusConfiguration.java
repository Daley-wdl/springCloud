package com.dylan.mp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


/**
 * mybatis-plus 配置
 *
 * @author xiaozao
 */
@Configuration(
	value = "classpath:/cloud-mybatis.yml"
)
@MapperScan({"com.dylan.**.mapper.**"})
public class MybatisPlusConfiguration {

}

