<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String taskNight = request.getParameter("task");
    boolean isItNight = LocalDateTime.now().getHour() >= 1 && LocalDateTime.now().getHour() <= 6;

    if (taskNight != null) {
        switch (Integer.parseInt(taskNight)) {
            case 4:
                if (isItNight) {
                    out.print("night.jsp");
                    System.out.println("night.jsp");
                }
                break;
            case 6:
                if (isItNight) {
                    out.print("night.jsp");
                }
                break;
            case 8:
                out.print("night.jsp has been called via jsp:forward");
                break;
            case 11:
                out.print("night.jsp has been called from forwarding");
                break;
            case 12:
                response.setContentType("text/html");
                response.getWriter().write("<h1>night.jsp has been called via Jjj GET-Method</h1>");
                break;
            case 13:
                response.setContentType("text/html");
                response.getWriter().write("<h1>night.jsp has been called via Jjj POST-Method</h1>");
                break;
        }
    }
%>