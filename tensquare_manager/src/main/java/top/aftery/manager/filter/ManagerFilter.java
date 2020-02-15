package top.aftery.manager.filter;

import cn.hutool.core.util.StrUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.aftery.common.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Struct;

/**
 * @ClassName ManagerFilter
 * @Description ManagerFilter 后台网关过滤器
 * @Author Aftery
 * @Date 2020/2/15 18:58
 * @Version 1.0
 */
@Slf4j
@Component
public class ManagerFilter extends ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil;


    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，
     * pre ：可以在请求被路由之前调用
     * route ：在路由请求时候被调用
     * post ：在route和error过滤器之后被调用
     * error ：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        // 前置过滤器
        return "pre";
    }

    /**
     * filterOrder ：通过int值来定义过滤器的执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        // 优先级为0，数字越大，优先级越低
        return 0;
    }

    /**
     * shouldFilter ：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }


    /**
     * run ：过滤器的具体逻辑。
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取header
        HttpServletRequest request = requestContext.getRequest();
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return null;
        }
        //后台登录的请求放行
        if (request.getRequestURI().toString().indexOf("login") > 0) {
            return null;
        }

        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            if (StrUtil.isNotEmpty(token)) {
                Claims claims = jwtUtil.parseJWT(token);
                if (claims != null) {
                    if ("admin".equalsIgnoreCase((String) claims.get("roles"))) {
                        requestContext.addZuulRequestHeader("Authorization", authorization);
                        log.info("经过了后台网关验证，添加了头信息:{}", authorization);
                        return null;
                    }
                }
            }
        }
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(403);
        requestContext.setResponseBody("无权访问");
        requestContext.getResponse().setCharacterEncoding("utf-8");
        requestContext.getResponse().setContentType("text/html;charset=UTF‐8");
        return null;
    }
}
