package springCloud.web.ZuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0; //优先级 , 数字越大,优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true; //是否执行该过滤器
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("zuul过滤器执行了");
        //向header中添加鉴权令牌
        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取header
       HttpServletRequest request =  requestContext.getRequest();
       String authorization =request.getHeader("Authorization");
       if(authorization != null){
           requestContext.addZuulRequestHeader("Authorization" , authorization);
       }
        return null;
    }
}
