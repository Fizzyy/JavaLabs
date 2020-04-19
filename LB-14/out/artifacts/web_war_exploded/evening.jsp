<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String taskEvening = request.getParameter("task");
    boolean isItEvening = LocalDateTime.now().getHour() >= 18;

    if (taskEvening != null) {
        switch (Integer.parseInt(taskEvening)) {
            case 4:
                if (isItEvening) {
                    out.print("evening.jsp");
                    System.out.println("evening.jsp");
                }
                break;
            case 6:
                if (isItEvening) {
                    out.print("evening.jsp");
                }
                break;
            case 8:
                out.print("evening.jsp has been called via jsp:forward");
                break;
            case 11:
                out.print("evening.jsp has been called from forwarding");
                break;
            case 12:
                response.setContentType("text/html");
                response.getWriter().write("<h1>evening.jsp has been called via Jjj GET-Method</h1>");
                break;
            case 13:
                response.setContentType("text/html");
                response.getWriter().write("<h1>evening.jsp has been called via Jjj POST-Method</h1>");
                break;
        }
    }
%>