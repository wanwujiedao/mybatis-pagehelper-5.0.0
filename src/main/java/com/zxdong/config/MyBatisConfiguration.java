package com.zxdong.config;

/**
 * Created by zxdong on 2017/4/1.
 */

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

/**
 * 分页拦截，在Controller里面需要添加PageHelper.startPage(1,10);
 */

@Configuration
public class MyBatisConfiguration {

    @Bean
    public PageHelper pageHelper() {
        System.out.println("万物皆导");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}





