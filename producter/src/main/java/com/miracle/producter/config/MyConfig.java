package com.miracle.producter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * MyConfig
 * Simple Class description.
 *
 * @author SHL
 * @version 1.0
 * @date 2020/9/4
 **/
@Configuration
/**
 * 通过其两个属性name以及havingValue来实现的，其中name用来从application.properties中读取某个属性值。
 * 如果该值为空，则返回false;
 * 如果值不为空，则将该值与havingValue指定的值进行比较，如果一样则返回true;否则返回false。
 * 如果返回值为false，则该configuration不生效；为true则生效。
 *
 * 作者：wyatt_plus
 * 链接：https://www.jianshu.com/p/68a75c093023
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@ConditionalOnProperty(value = "spring.my.config.value")
public class MyConfig {
    @Value("${spring.my.config.value}")
    private String clusterNodes;
    @PostConstruct
    public void init(){
        System.out.println("我被加载了");
    }
}
