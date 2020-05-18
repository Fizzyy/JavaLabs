package task2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Ccc", urlPatterns = "/Ccc")
public class Ccc extends HttpServlet {
    private CBean cBean;

    private void setCBeanValues(String value1, String value2, String value3) {
        if (value1 != null && !value1.equals("")) {
            this.cBean.setValue1(value1);
        }
        if (value2 != null && !value2.equals("")) {
            this.cBean.setValue2(value2);
        }
        if (value3 != null && !value3.equals("")){
            this.cBean.setValue3(value3);
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        this.cBean = new CBean();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().removeAttribute("oldReq");
        getServletContext().removeAttribute("newReq");

        var listener = req.getParameter("listener");
        if (listener != null && !listener.equals("")) {
            switch (listener) {
                case "add":
                    req.getSession().setAttribute("List", "new");
                    break;
                case "replace":
                    req.getSession().setAttribute("List", "rep");
                    break;
                case "remove":
                    if (req.getSession().getAttribute("List") != null) {
                        req.getSession().removeAttribute("List");
                    }
                    break;
            }
        }

        var error = req.getParameter("error");
        if (error != null) {
            String firstFilterHeader = resp.getHeader("FirstFilter");
            String secondFilterHeader = resp.getHeader("SecondFilter");
            String thirdFilterHeader = resp.getHeader("ThirdFilter");

            resp.setContentType("text/html");
            resp.getWriter().write("<p>FirstFilter: " + firstFilterHeader + "</p>");
            resp.getWriter().write("<p>SecondFilter: " + secondFilterHeader + "</p>");
            resp.getWriter().write("<p>ThirdFilter: " + thirdFilterHeader + "</p>");
            resp.getWriter().write("<p><b>All filters have been passed</b></p>");
        } else {
            super.service(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var cbean = request.getParameter("CBean");
        var value1 = request.getParameter("Value1");
        var value2 = request.getParameter("Value2");
        var value3 = request.getParameter("Value3");
        getServletContext().setAttribute("atrCbean", this.cBean);

        if (cbean.equals("new")) {
            this.cBean = new CBean();
            setCBeanValues(value1, value2, value3);
            getServletContext().setAttribute("atrCbean", this.cBean);
        } else if (cbean.equals("old")) {
            setCBeanValues(value1, value2, value3);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Ccc.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var cbean = request.getParameter("CBean");
        var typee = request.getParameter("typee");
        var value1 = request.getParameter("Value1");
        var value2 = request.getParameter("Value2");
        var value3 = request.getParameter("Value3");

        if (typee != null && typee.equals("request")) {
            if (cbean != null && cbean.equals("new")) {
                var newCbean = new CBean();
                if (value1 != null && !value1.equals("")) {
                    newCbean.setValue1(value1);
                }
                if (value2 != null && !value2.equals("")) {
                    newCbean.setValue2(value2);
                }
                if (value3 != null && !value3.equals("")){
                    newCbean.setValue3(value3);
                }
                request.setAttribute("atrCbeanRequest", newCbean);
                getServletContext().setAttribute("newReq", "request");
            } else if (cbean != null && cbean.equals("old")) {
                setCBeanValues(value1, value2, value3);
                request.setAttribute("atrCbeanRequest", request.getAttribute("atrCbeanRequest"));
                getServletContext().setAttribute("oldReq", "request");
            }

        } else if (typee != null && typee.equals("session")) {
            HttpSession session = request.getSession();
            if (cbean != null && cbean.equals("new")) {
                var newCBean = new CBean();
                if (value1 != null && !value1.equals("")) {
                    newCBean.setValue1(value1);
                }
                if (value2 != null && !value2.equals("")) {
                    newCBean.setValue2(value2);
                }
                if (value3 != null && !value3.equals("")){
                    newCBean.setValue3(value3);
                }
                session.setAttribute(session.getId(), newCBean);
            } else if (cbean != null && cbean.equals("old")) {
                setCBeanValues(value1, value2, value3);
                session.setAttribute(session.getId(), session.getAttribute(session.getId()));
            }
        }

        response.sendRedirect("http://localhost:8080/AS_ydssi/Ccc.jsp");
    }
}
