<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String taskMorning = request.getParameter("task");
    boolean isItMorning = LocalDateTime.now().getHour() >= 7 && LocalDateTime.now().getHour() <= 11;

    if (taskMorning != null) {
        switch (Integer.parseInt(taskMorning)) {
            case 4:
                if (isItMorning) {
                    out.print("morning.jsp");
                    System.out.println("morning.jsp");
                }
                break;
            case 6:
                if (isItMorning) {
                    out.print("morning.jsp");
                }
                break;
            case 8:
                out.print("morning.jsp has been called via jsp:forward");
                break;
            case 11:
                out.print("morning.jsp has been called via requestDispatch");
                break;
            case 12:
                response.setContentType("text/html");
                response.getWriter().write("<h1>morning.jsp has been called via Jjj GET-Method</h1>");
                break;
            case 13:
                response.setContentType("text/html");
                response.getWriter().write("<h1>morning.jsp has been called via Jjj POST-Method</h1>");
                break;
        }
    }
%>