package com.oldmee.configclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConfigClientApplication {

    private Logger logger = LoggerFactory.getLogger("");

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    private String foo;

    @RequestMapping("getFoo")
    public String getFooInfo(HttpServletRequest request, HttpServletResponse response) {
        logger.info("request url="+request.getRequestURL().toString());
        logger.info("request ContextPath="+request.getContextPath());
        logger.info("request RemoteUser="+request.getRemoteUser());
        logger.info("request HeaderNames="+request.getHeaderNames());
        logger.info("response HeaderNames="+response.getHeaderNames());
        return foo;
    }
}
