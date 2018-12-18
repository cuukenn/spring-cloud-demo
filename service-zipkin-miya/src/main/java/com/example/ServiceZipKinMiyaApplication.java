package com.example;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @program: clouddemo
 * @author: changgg
 * @create: 2018-12-18 10:51
 **/

@SpringBootApplication
@RestController
public class ServiceZipKinMiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipKinMiyaApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceZipKinMiyaApplication.class.getName());


    @RequestMapping("/hi")
    public String home() {
        LOG.log(Level.INFO, "hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info() {
        LOG.log(Level.INFO, "info is being called");
        System.out.println("aa");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
