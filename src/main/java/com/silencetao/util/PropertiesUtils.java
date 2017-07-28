package com.silencetao.util;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 加载配置文件工具类
 * 配置文件路径:
 * classpath:properties/configuration.properties
 * @author Silence
 * create time 2017年7月28日 下午4:22:57
 * @version 1.0.1
 */
public class PropertiesUtils extends PropertyPlaceholderConfigurer {
    private static Properties properties;

    /**
     * 根据key获取配置文件的value
     * @version 1.0.1 
     * @param key
     * @return
     */
    public static String getProperties(String key) {
        return properties.getProperty(key);
    }

    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        properties = props;
        super.processProperties(beanFactoryToProcess, props);
    }
    
    private PropertiesUtils() {}
}
