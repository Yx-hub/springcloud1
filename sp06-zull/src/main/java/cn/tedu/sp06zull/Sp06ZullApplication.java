package cn.tedu.sp06zull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class Sp06ZullApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp06ZullApplication.class, args);
    }

}
