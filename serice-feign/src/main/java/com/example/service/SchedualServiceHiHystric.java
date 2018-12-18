package com.example.service;

import org.springframework.stereotype.Component;

/**
 * @program: clouddemo
 * @author: changgg
 * @create: 2018-12-17 16:54
 **/
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
