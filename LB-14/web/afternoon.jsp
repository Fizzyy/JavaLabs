<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String taskAfternoon = request.getParameter("task");
    boolean isItAfternoon = LocalDateTime.now().getHour() >= 12 && LocalDateTime.now().getHour() <= 17;

    if (taskAfternoon != null) {
        switch (Integer.parseInt(taskAfternoon)) {
            case 4:
                if (isItAfternoon) {
                    out.print("afternoon.jsp via @include");
                    System.out.println("afternoon.jsp");
                }
                break;
            case 6:
                if (isItAfternoon) {
                    out.print("afternoon.jsp");
                }
                break;
            case 8:
                out.print("afternoon.jsp has been called via jsp:forward");
                break;
            case 11:
                out.print("afternoon.jsp has been called from forwarding");
                break;
            case 12:
                response.setContentType("text/html");
                response.getWriter().write("<h1>afternoon.jsp has been called via Jjj GET-Method</h1>");
                break;
            case 13:
                response.setContentType("text/html");
                response.getWriter().write("<h1>afternoon.jsp has been called via Jjj POST-Method</h1>");
                break;
        }
    }
%>

