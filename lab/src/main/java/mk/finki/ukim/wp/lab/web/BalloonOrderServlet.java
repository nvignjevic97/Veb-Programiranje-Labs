package mk.finki.ukim.wp.lab.web;

import mk.finki.ukim.wp.lab.service.OrderService;
import org.thymeleaf.spring5.SpringTemplateEngine;
import mk.finki.ukim.wp.lab.model.Order;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="BalloonOrderServlet", urlPatterns = "/BalloonOrder")
public class BalloonOrderServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String color = (String) req.getSession().getAttribute("color");
        String size = (String) req.getSession().getAttribute("size");
        Order order = new Order(color, size);
        req.getSession().setAttribute("order",order);
        context.setVariable("order", order);
        this.springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        Order order = new Order((String) req.getSession().getAttribute("color"),(String) req.getSession().getAttribute("size"),clientName, clientAddress, 0L);
        req.getSession().setAttribute("order",order);
        resp.sendRedirect("/ConfirmationInfo");
    }
}
