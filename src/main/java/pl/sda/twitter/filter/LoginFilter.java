package pl.sda.twitter.filter;

import pl.sda.twitter.constans.SessionValues;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;

@WebFilter(urlPatterns = "/add-article.jsp")
public class LoginFilter implements Filter {
    private final String userValue = SessionValues.USER.getValue();
    private final String messages = SessionValues.MESSAGES.getValue();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final Object user = httpRequest.getSession().getAttribute(userValue);
        final HttpSession httpSession = httpRequest.getSession();
        if (user == null) {
            final HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpSession.setAttribute(messages, Collections.singletonList("Zaloguj się aby kontynuować"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(httpRequest, httpResponse);
        }
        chain.doFilter(request, response);
    }
}
