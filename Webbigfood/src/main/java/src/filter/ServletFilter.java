package src.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import src.bigfood.tabl.User_account;
import src.bigfoodlog.logUser;

@WebFilter("/*")
public class ServletFilter implements Filter {
 
    public ServletFilter() {
    }
 
    public void destroy() {
    }
 
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        System.out.println("Security Filter works");
        
        String servletPath = request.getServletPath();
        
        if (servletPath.equals("/login")) {
        	System.out.println("Security Filter transfer to - " + servletPath +".java");
            chain.doFilter(request, response);
            return;
        }
        
        else {
        User_account logUs = logUser.getlogUser(request.getSession());      
        if (logUs == null) {System.out.println("request.getContextPath()" + request.getContextPath()); response.sendRedirect(request.getContextPath() + "/login");}
        else {
        System.out.println("logUs " + logUs);
        
        chain.doFilter(request, response);
        }
    }
    }
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
}