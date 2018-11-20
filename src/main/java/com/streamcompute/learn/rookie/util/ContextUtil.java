package com.streamcompute.learn.rookie.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextUtil.applicationContext = applicationContext;

    }public static ApplicationContext getCtx(){
        return ContextUtil.applicationContext;
    }
//    public static <T> getBean(Class<T> res){
//        return ContextUtil.applicationContext.getBean(res);
//
//    }



}
