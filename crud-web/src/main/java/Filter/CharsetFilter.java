package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "CharsetFilter", urlPatterns = "/*", initParams =
@WebInitParam(name = "charset", value = "UTF-8"))
public class CharsetFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String charset = request.getServletContext().getFilterRegistration("CharsetFilter").getInitParameter("charset");
        request.setCharacterEncoding(charset);
        response.setContentType("text/html;charset="+charset);
        chain.doFilter(request, response);
    }
}
