package com.smile.core.session;

import com.smile.core.cache.LocalCache;
import com.smile.core.domain.SysUser;
import com.smile.core.utils.UserHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录认证的拦截器
 */
@Service
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * Handler执行完成之后调用这个方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exc)
            throws Exception {

    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
                             Object handler) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取Session  
        String sid = request.getHeader("sid");
        if (StringUtils.isNoneEmpty(sid)) {
            SysUser sysUser = LocalCache.get(sid);
            if (sysUser != null) {
                UserHolder.setSysUser(sysUser);
                return true;
            }
        }
        request.getRequestDispatcher("/login?code=500").forward(request, servletResponse);
        return false;

    }

}  