package com.xrui.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xrui.pojo.Result;
import com.xrui.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NXRUI
 * @version 1.0
 * @date 2023/5/23 20:58
 * @description: 拦截器（作用在Spring环境下的）
 */
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    private static final String NOT_LOGIN = "NOT_LOGIN";



    //目标资源方法前执行，返回true放行，返回false不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.获取请求的url
        String url = request.getRequestURI().toString();

        log.info("请求的url:{}", url);

        //2.判断请求的url中是否包含登录
        if (url.contains("/login")) {
            log.info("登录方法...放行");
            return true;
        }

        //3.不包含,则获取请求头中是否包含jwt令牌
        String token = request.getHeader("token");

        //4.判断,令牌是否存在
        if (!StringUtils.hasLength(token)) {
            //如果不存在,返回错误信息给前端,并且不放行
            Result error = Result.error("NOT_LOGIN");
            //把这个Result转成JSON(调用Alibaba的转jsonAPI)
            String s = JSONObject.toJSONString(error);

            //响应给前端(通过response)
            response.getWriter().write(s);
            //不放行,返回false
            return false;

        }

        //5.存在,则解析这个jwt令牌(如果报异常,则说明这个令牌有问题,直接返回false)
        try {
            JwtUtils.parseJWT(token);
            log.info("令牌正常!放行");
            //如果没有出异常,则说明解析成功:放行
            return true;
        } catch (Exception e) {
            //解析失败
            log.info("令牌解析失败!返回登录");
            //给前端返回令牌解析失败的结果
            Result error = Result.error(NOT_LOGIN);
            //转成JSON格式
            String s = JSONObject.toJSONString(error);
            //响应给前端
            response.getWriter().write(s);
            //并且返回false,表示不放行
            return false;
        }



    }

    //目标资源方法后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //全部视图渲染后执行，最后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
