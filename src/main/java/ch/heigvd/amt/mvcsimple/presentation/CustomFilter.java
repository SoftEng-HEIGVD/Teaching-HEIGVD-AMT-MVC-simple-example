package ch.heigvd.amt.mvcsimple.presentation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CustomFilter", urlPatterns = "/*")
public class CustomFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*
         The pipeline is first going from the app server towards the controller.
         We can log the request, transform the request. We can also block the request
         (by not calling chain.doFilter(req, resp);
         */

        req.setAttribute("computedByFilter", "yellow");

        chain.doFilter(req, resp);

        /*
         We are on the way back. Now, we can transform the response. But to do that,
         we would need to send a wrapper to the chain in the previous call. You can
         find an example in the Java EE 5 tutorial
         */


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
