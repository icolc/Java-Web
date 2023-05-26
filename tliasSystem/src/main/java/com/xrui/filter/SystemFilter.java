package com.xrui.filter;

import com.alibaba.fastjson.JSONObject;
import com.xrui.pojo.Result;
import com.xrui.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NXRUI
 * @version 1.0
 * @date 2023/5/23 16:13
 * @description:    作用在Tomcat之后，Spring环境之前
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class SystemFilter implements Filter {
    //主方法：每次请求都需要调用这个方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)  servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取请求的url
        String url = request.getRequestURI().toString();
        log.info("请求的url:{}",url);

        //2.判断请求的路径中，是否包含login，如果包括则说明是登录，放行
        if (url.contains("login")){
            log.info("登录操作直接放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //3.获取请求头中的令牌（token）
        String token = request.getHeader("token");
        //4.判断令牌是否存在，如果不存在，则返回错误结果（未登录）
        if (!StringUtils.hasLength(token)){
            log.info("请求头位为空，返回未登录的信息");
            Result notLogin = Result.error("NOT_LOGIN");
            //手动转换JSON
            String s = JSONObject.toJSONString(notLogin);
            //通过响应，响应回去
            response.getWriter().write(s);
            return;
        }
        //5.解析token，如果解析失败，则返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换JSON
            String s = JSONObject.toJSONString(error);
            //通过响应，响应回去
            response.getWriter().write(s);
            return;
        }
        //6.放行
        log.info("令牌合法，放行！");
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
