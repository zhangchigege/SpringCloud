package BaseController.controller;

import BaseController.service.UserService;
import BaseController.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll" , method = RequestMethod.GET)
    public void findAll(){
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

}
