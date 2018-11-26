package springCloud.Controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springCloud.Controller.client.CloudClient;

@RestController
@RequestMapping("/test")
public class CloudController {

    @Autowired
    private CloudClient cloudClient;

    @RequestMapping("/print")
    public void test(){
        cloudClient.print();
        System.out.println("你好,这里是controller层");
    }
}
