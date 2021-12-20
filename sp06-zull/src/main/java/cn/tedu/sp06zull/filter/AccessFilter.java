package cn.tedu.sp06zull.filter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import cn.tedu.web.util.JsonResult;

@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

    //设置过滤器的类型
    @Override
    public String filterType() {
        //return "pre"
        log.info("Zuul自动配置过滤器类型");
        return FilterConstants.PRE_TYPE;
    }

    //设置过滤器的顺序号
    @Override
    public int filterOrder() {
        log.info("Zuul自动配置过滤器的顺序号");
        return 6;
    }

    //针对不同的请求判断是否要执行过滤代码
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String)ctx.get(FilterConstants.SERVICE_ID_KEY);
        if(serviceId.equals("item-service")){
            return true;
        }
        return false;
    }

    //过滤流程代码
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        if(req.getParameter("token") == null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody(JsonResult.err().code(JsonResult.NOT_LOGIN).toString());
        }
        return null;
    }
}
