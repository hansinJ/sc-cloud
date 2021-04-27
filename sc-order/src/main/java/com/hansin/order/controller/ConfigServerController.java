package com.hansin.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 测从配置中心sc-config-server拿取配置
 * @Author Hans
 * @Date 13:52 2020/3/7
 **/
@RefreshScope
@RestController
@RequestMapping("v1/config")
public class ConfigServerController {
    Logger logger = LoggerFactory.getLogger(getClass());

    // 第一种获取方法
    @Value("${username}")
    private String userName;

    @Value("${template:222}")
    private String template;

    // 第二种方法，从spring容器中获取
    @Autowired
    private Environment environment;

    @GetMapping
    public String getConfigProperties(HttpServletRequest request){
        logger.info("==================已经调用==========" + request.getRemotePort());
        logger.info("@Value userName->{}",userName);
        logger.info("environment ->{}",environment.getProperty("username"));

        logger.info("@Value template->{}",template);
        logger.info("environment ->{}",environment.getProperty("template"));
        return "success";
    }
}
