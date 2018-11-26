package springCloud.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import utils.JwtUtil;

@SpringBootApplication
@EnableEurekaClient
public class CloudApplicationRun {

    public static void main(String[] args) {
        SpringApplication.run(CloudApplicationRun.class,args);
    }


    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }

}