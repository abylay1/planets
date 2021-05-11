package com.planets.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.planets.model.User;

@WebFilter(filterName = "SecurityFilter", urlPatterns = "/admin/*")
public class SecurityFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String URI = httpServletRequest.getRequestURI();

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("current-user");

        if ((URI.equals("/admin") || URI.equals("/admin/big-planets") || URI.equals("/admin/small-planets") || URI.equals("/admin/calculate") || URI.equals("/admin/")) && user == null) {
            httpServletResponse.sendRedirect("/admin/login");
            return;
        }

        if (URI.equals("/admin/login") && user != null) {
            httpServletResponse.sendRedirect("/admin");
            return;
        }

        chain.doFilter(request, response);
    }
}
