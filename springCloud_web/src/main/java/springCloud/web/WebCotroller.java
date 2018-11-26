package springCloud.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class WebCotroller {

    public static void main(String[] args) {
        SpringApplication.run(WebCotroller.class,args);
    }



}

