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
 * SimpleServletFilter реализует интерфейс Filter 
 */
@WebFilter("/ServletFilter")
public class ServletFilter implements Filter
{
    private FilterConfig filterConfig;
    private static ArrayList<String> pages;  // хранилище страниц

    /**
     * Конструктор по умолчанию 
     */
    public ServletFilter() 
    {
        // Создание хранилища страниц
        if (pages == null)
            pages = new ArrayList<String>();
    }

    /**
     * Метод освобождения ресурсов
     * @see Filter#destroy()
     */
    public void destroy() 
    {
        filterConfig = null;
    }

    /**
     * Метод инициализации фильтра
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException
    {
        filterConfig = fConfig;
    }
    /**
     * Метод фильтрации
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, 
                        FilterChain filterChain) throws IOException, ServletException
    {
        // Если фильтр активной, то выполнить проверку
        if (filterConfig.getInitParameter("active").equalsIgnoreCase("true")) {
            HttpServletRequest req = (HttpServletRequest)request;
            // Раскладываем адрес на составляющие
            String[] list = req.getRequestURI().split("/");
            System.out.println("list - " + list[1]);
            // Извлекаем наименование страницы 
            String page = null;
            if (list[list.length - 1].indexOf(".jsp") > 0) {
                page = list[list.length - 1];
            }
            System.out.println("page - " + page);
            // Если открывается главная страница, то выполняем проверку
            if ((page != null) && page.equalsIgnoreCase("homeView.jsp")) {
                // Если была предварительно открыта одна из страниц 
                // login.jsp или registration.jsp, то передаем управление
                // следующему элементу цепочки фильтра
                if (pages.contains("LoginView.jsp") ) {
                    filterChain.doFilter(request, response);
                    return;
                } else {
                    // Перенаправление на страницу login.jsp
                    ServletContext ctx = filterConfig.getServletContext();
                    RequestDispatcher dispatcher = ctx.getRequestDispatcher("/LoginView.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            } else if (page != null) {
                // Добавляем страницу в список
                if (!pages.contains(page))
                    pages.add(page);
            }
        }
        filterChain.doFilter(request, response);
    }
}