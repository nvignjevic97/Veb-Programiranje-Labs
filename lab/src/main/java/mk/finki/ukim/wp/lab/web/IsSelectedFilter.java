package mk.finki.ukim.wp.lab.web;

import mk.finki.ukim.wp.lab.model.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class IsSelectedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Order order = (Order) request.getSession().getAttribute("order");

        String path = request.getServletPath();

        if (!"".equals(path) && !"/".equals(path) && order==null) {
            response.sendRedirect("");
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
