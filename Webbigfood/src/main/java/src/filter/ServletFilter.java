package src.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * SimpleServletFilter ��������� ��������� Filter 
 */
@WebFilter("/ServletFilter")
public class ServletFilter implements Filter
{
    private FilterConfig filterConfig;
    private static ArrayList<String> pages;  // ��������� �������

    /**
     * ����������� �� ��������� 
     */
    public ServletFilter() 
    {
        // �������� ��������� �������
        if (pages == null)
            pages = new ArrayList<String>();
    }

    /**
     * ����� ������������ ��������
     * @see Filter#destroy()
     */
    public void destroy() 
    {
        filterConfig = null;
    }

    /**
     * ����� ������������� �������
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException
    {
        filterConfig = fConfig;
    }
    /**
     * ����� ����������
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, 
                        FilterChain filterChain) throws IOException, ServletException
    {
        // ���� ������ ��������, �� ��������� ��������
        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")) {
            HttpServletRequest req = (HttpServletRequest)request;
            // ������������ ����� �� ������������
            String[] list = req.getRequestURI().split("/");
            System.out.println("list - " + list[1]);
            // ��������� ������������ �������� 
            String page = null;
            if (list[list.length - 1].indexOf(".jsp") > 0) {
                page = list[list.length - 1];
            }
            System.out.println("page - " + page);
            // ���� ����������� ������� ��������, �� ��������� ��������
            if ((page != null) && page.equalsIgnoreCase("homeView.jsp")) {
                // ���� ���� �������������� ������� ���� �� ������� 
                // login.jsp ��� registration.jsp, �� �������� ����������
                // ���������� �������� ������� �������
                if (pages.contains("LoginView.jsp") ) {
                    filterChain.doFilter(request, response);
                    return;
                } else {
                    // ��������������� �� �������� login.jsp
                    ServletContext ctx = filterConfig.getServletContext();
                    RequestDispatcher dispatcher = ctx.getRequestDispatcher("/LoginView.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            } else if (page != null) {
                // ��������� �������� � ������
                if (!pages.contains(page))
                    pages.add(page);
            }
        }
        filterChain.doFilter(request, response);
    }
}