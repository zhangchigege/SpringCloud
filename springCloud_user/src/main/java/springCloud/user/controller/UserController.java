package springCloud.user.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springCloud.user.pojo.User;
import springCloud.user.service.UserService;
import utils.JwtUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    //用户登录
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        User loginUser = userService.login(user);
        if(loginUser == null){
            return new Result(false , StatusCode.ERROR , "登录失败");
        }
        String token = jwtUtil.createJWT(user.getEmail() , user.getName() , "user");
        return new Result(true , StatusCode.OK , token);
    }

    //查询用户
    @RequestMapping(value = "/findAll" , method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true , StatusCode.OK , "查询成功" , userService.findAll());
    }
    //用户注册
    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public Result createUser(@RequestBody User user ){
        userService.insert(user);
        return new Result(true,StatusCode.OK , "注册成功");
    }



}
