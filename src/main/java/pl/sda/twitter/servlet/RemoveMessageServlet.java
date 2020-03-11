package pl.sda.twitter.servlet;

import pl.sda.twitter.constans.SessionValues;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/remove-message")
public class RemoveMessageServlet extends HttpServlet {

    public static final String MESSAGE = SessionValues.MESSAGES.getValue();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageParameter = req.getParameter("message");
        ArrayList<String> messages = (ArrayList<String>) req.getSession().getAttribute(MESSAGE);
        messages.remove(messageParameter);
        req.getSession().setAttribute(MESSAGE, messages);
    }
}
