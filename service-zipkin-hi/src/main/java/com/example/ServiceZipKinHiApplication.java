package com.example;

import brave.sampler.Sampler;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: clouddemo
 * @author: changgg
 * @create: 2018-12-18 10:51
 **/
@SpringBootApplication
@RestController
public class ServiceZipKinHiApplication {
    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOG = Logger.getLogger(ServiceZipKinHiApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipKinHiApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome() {
        LOG.log(Logger.Level.INFO, "calling trace service-hi  ");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        LOG.log(Logger.Level.INFO, "calling trace service-hi ");

        return "i'm service-hi";

    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
