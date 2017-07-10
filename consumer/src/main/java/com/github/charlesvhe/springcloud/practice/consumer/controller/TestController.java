package com.github.charlesvhe.springcloud.practice.consumer.controller;

import com.github.charlesvhe.springcloud.practice.consumer.feign.User;
import com.github.charlesvhe.springcloud.practice.consumer.feign.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by charles on 2017/5/25.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        List<User> userList = userService.query();
        System.out.println(userList);

        String result = restTemplate.getForObject("http://provider/user", String.class);
        System.out.println(result);
        return result;
    }
}
