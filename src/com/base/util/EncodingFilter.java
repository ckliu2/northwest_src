package com.base.util;

import java.io.IOException;
import javax.servlet.*;

public class EncodingFilter
    implements Filter
{

    public EncodingFilter()
    {
        encoding = null;
        filterConfig = null;
        ignore = true;
    }

    public void destroy()
    {
        encoding = null;
        filterConfig = null; 
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException
    {
        if(ignore || request.getCharacterEncoding() == null) {
            //System.out.println("request.getCharacterEncoding()=" + selectEncoding(request));
            request.setCharacterEncoding(selectEncoding(request));
        }
        chain.doFilter(request, response);
        if(ignore || response.getCharacterEncoding() == null) {
            //System.out.println("response.getCharacterEncoding()=" + selectEncoding(response));
            response.setCharacterEncoding(selectEncoding(response));
        }
    }

    public void init(FilterConfig filterConfig)
        throws ServletException
    {
        this.filterConfig = filterConfig;
        encoding = filterConfig.getInitParameter("encoding");
        String value = filterConfig.getInitParameter("ignore");
        if(value == null)
            ignore = true;
        else
        if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("yes"))
            ignore = true;
        else
            ignore = false;
    }

    protected String selectEncoding(ServletRequest request)
    {
        return encoding;
    }

    protected String selectEncoding(ServletResponse response)
    {
        //return encoding;
        return "UTF-8";
    }

    public FilterConfig getFilterConfig()
    {
        return filterConfig;
    }

    public void setFilterConfig(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    protected String encoding;
    protected FilterConfig filterConfig;
    protected boolean ignore;
}