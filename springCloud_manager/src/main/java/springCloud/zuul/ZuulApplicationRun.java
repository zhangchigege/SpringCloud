package springCloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import utils.JwtUtil;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplicationRun.class , args);
    }
    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }

}
