package com.zxdong;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * Created by zxdong on 2017/3/30.
 */
@SpringBootApplication
//扫描该包下相应的class，主要是持久化类
@MapperScan("com.zxdong.mapper")
public class TestSpringBoot {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        // 1.需要定义一个convert转换消息对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();

        // 2.添加fastJson的配置信息，比如：是否需要格式化返回的json数据
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        // 3.在convert中添加配置信息
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        // 4.将convert添加到converts中
        HttpMessageConverter<?> converters=fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converters);
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(TestSpringBoot.class);
    }
}
