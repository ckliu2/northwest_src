package com.base.web.util;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class MessageFilter
    implements Filter
{

    public MessageFilter()
    {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest)req;
        Object message = request.getSession().getAttribute("message");
        if(message != null)
        {
            request.setAttribute("message", message);
            request.getSession().removeAttribute("message");
        }
        request.setAttribute("requestURL", request.getRequestURL());
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterconfig)
    {
    }

    public void destroy()
    {
    }
}