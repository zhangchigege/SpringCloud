package springCloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;

public class ManagerFilter extends ZuulFilter {

    private JwtUtil jwtUtil;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("zuul过滤器");
       RequestContext requestContext = RequestContext.getCurrentContext();
       HttpServletRequest request =requestContext.getRequest();
       if(request.getMethod().equals("OPTIONS")){
           return null;
       }
        String url =request.getRequestURI().toString();
       if(url.indexOf("/admin/login")>0){
           System.out.println("登录页面"+url);
           return null;
       }
       String authHeader = (String)request.getHeader("Authorization");//获取头信息
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7);
            Claims claims = jwtUtil.parseJWT(token);
            if(claims != null){
                if("admin".equals(claims.get("roles"))){
                    requestContext.addZuulRequestHeader("Authorization" , authHeader);
                    System.out.println("token验证通过,添加了头信息" + authHeader);
                    return null;
                }
            }
        }
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(401);
        requestContext.setResponseBody("无权访问");
        requestContext.getResponse().setContentType("text/html;charset=UTF‐8");
        return null;
    }
}
