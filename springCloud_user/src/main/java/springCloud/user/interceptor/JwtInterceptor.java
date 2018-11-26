package springCloud.user.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;
    //在进入controller之前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器！！！");
        //得到token请求头
        String header = request.getHeader("Authorization");
        if(header!=null && !"".equals(header)){
            if(header.startsWith("Bearer ")){
                //得到当前的令牌
                String token = header.substring(7);
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    //得到当前用户的角色
                    String roles = (String) claims.get("roles");
                    if (roles!=null && !roles.equals("")){
                        //把不同角色的用户解析后的token放在request域中
                        if(roles.equals("user")){
                            request.setAttribute("user_claims", claims);
                        }
                        if(roles.equals("admin")){
                            request.setAttribute("admin_claims", claims);
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    //controller出来之后拦截
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    //最终客户端执行完毕后拦截
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
