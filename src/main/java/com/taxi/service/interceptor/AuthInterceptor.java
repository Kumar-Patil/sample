package com.taxi.service.interceptor;

/**
 *
 * @author
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxi.service.AccessTokenService;
import com.taxi.to.Response;
import com.taxi.util.Constants;
import com.taxi.util.StaticSessionHandler;
import com.taxi.util.Util;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger("AuthInterceptor");

    @Autowired
    AccessTokenService accessTokenService;

    @Override
    @CrossOrigin
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String api_key = httpServletRequest.getHeader("api_key");
        String uri = httpServletRequest.getRequestURI();
        if (Util.containsAKeyword(uri, Constants.urls())) {
            return true;
        } else if (true/*StaticSessionHandler.isValidAccessToken(isValid(httpServletRequest))*/) {
            //accessTokenService.isAccessTokenValid(isValid(httpServletRequest), api_key);
            httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
            return true;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            Response response = new Response(Constants.ERROR_RESPONCE, Constants.UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.getWriter().write(mapper.writeValueAsString(response));
            return false;
        }
    }

    @Override
    @CrossOrigin
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    @CrossOrigin
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info(" After Completion ");
    }

    private String isValid(HttpServletRequest httpServletRequest) {
        try {
            String userId = httpServletRequest.getParameter("userId");
            return userId;
        } catch (NumberFormatException ex) {

        }
        return null;
    }
}
