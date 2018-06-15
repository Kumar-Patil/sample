package com.taxi.service.interceptor;

/**
 *
 * @author
 */
import com.taxi.service.AccessTokenService;
import com.taxi.util.Constants;
import com.taxi.util.Util;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger("AuthInterceptor");

    @Autowired
    AccessTokenService accessTokenService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String api_key = httpServletRequest.getHeader("api_key");
        String uri = httpServletRequest.getRequestURI();
        if (Util.containsAKeyword(uri, Constants.urls())) {
            return true;
        } else if (accessTokenService.isAccessTokenValid(isValid(httpServletRequest), api_key)) {
            return true;
        } else {
            throw new InvalidClientException();
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info(" After Completion ");
    }

    private Long isValid(HttpServletRequest httpServletRequest) {
        try {
            String userId = httpServletRequest.getParameter("userId");
            return Long.parseLong(userId);
        } catch (NumberFormatException ex) {

        }
        return 0L;
    }
}
