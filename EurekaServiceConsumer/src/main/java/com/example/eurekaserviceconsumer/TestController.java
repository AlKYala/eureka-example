package com.example.eurekaserviceconsumer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/checkconnectiontoprovider")
    public String checkConnectionToProvider() {

        InstanceInfo service = eurekaClient
                .getApplication("spring-cloud-eureka-client-service-provider")
                .getInstances()
                .get(0);

        String hostName = service.getHostName();
        int port = service.getPort();

        //return String.format("%s/%d/test/check", hostName, port);

        RestTemplate template = new RestTemplate();

        return template.getForObject(String.format("http://%s:%d/test/check", hostName, port), String.class);

    }
}
