package com.chaos_trials.api.infrastrucure.config.cors;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.Filter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest requestHttpServelt = (HttpServletRequest) request;
        HttpServletResponse responseHttpServelt = (HttpServletResponse) response;
        String originPermitida = "http://localhost:4200";
        responseHttpServelt.setHeader("Access-Control-Allow-Origin", originPermitida);
        responseHttpServelt.setHeader("Access-Control-Allow-Credentials", "true");
        responseHttpServelt.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");


        if ("OPTIONS".equals(requestHttpServelt.getMethod())
                && originPermitida.equals(requestHttpServelt.getHeader("Origin"))) {
            responseHttpServelt.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT");
            responseHttpServelt.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");

            responseHttpServelt.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0){

    }
}
