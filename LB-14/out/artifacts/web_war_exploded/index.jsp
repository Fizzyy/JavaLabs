<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        StringBuilder timeBuilder = new StringBuilder();

        if (LocalDateTime.now().getHour() >= 1 && LocalDateTime.now().getHour() <= 6) {
            timeBuilder.append("Good night!");
        } else if (LocalDateTime.now().getHour() >= 7 && LocalDateTime.now().getHour() <= 11) {
            timeBuilder.append("Good morning!");
        } else if (LocalDateTime.now().getHour() >= 12 && LocalDateTime.now().getHour() <= 17) {
            timeBuilder.append("Good afternoon!");
        } else if (LocalDateTime.now().getHour() >= 18) {
            timeBuilder.append("Good evening!");
        }
    %>
    <p>Task 1: <%=timeBuilder%></p>

    <p>Task 2:</p>
    <table>
        <%
            String[] formattedDates = new String[7];
            String[] formattedDays = new String[7];

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Calendar calendar = Calendar.getInstance();

            for (int i = 0; i < formattedDates.length; i++) {
                calendar.add(Calendar.DATE, 1);
                formattedDates[i] = simpleDateFormat.format(calendar.getTime());
                switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                    case Calendar.MONDAY:
                        formattedDays[i] = "Monday";
                        break;
                    case Calendar.TUESDAY:
                        formattedDays[i] = "Tuesday";
                        break;
                    case Calendar.WEDNESDAY:
                        formattedDays[i] = "Wednesday";
                        break;
                    case Calendar.THURSDAY:
                        formattedDays[i] = "Thursday";
                        break;
                    case Calendar.FRIDAY:
                        formattedDays[i] = "Friday";
                        break;
                    case Calendar.SATURDAY:
                        formattedDays[i] = "Saturday";
                        break;
                    case Calendar.SUNDAY:
                        formattedDays[i] = "Sunday";
                        break;
                }
        %>
        <tr>
            <td><%= formattedDates[i]%></td>
            <td><%= formattedDays[i]%></td>
        </tr>
        <%
            }
        %>
    </table>

    <p>Task 3:</p>
    <form>
        <input type="hidden" name="task" value="4" />
        <input type="submit" value="press"/>
    </form>
    <%@include file="night.jsp" %>
    <%@include file="morning.jsp" %>
    <%@include file="afternoon.jsp" %>
    <%@include file="evening.jsp" %>
    <p>Task 6:</p>
    <%= "Calling via jsp:include = "%>
    <jsp:include page="night.jsp?task=6"/>
    <jsp:include page="morning.jsp?task=6"/>
    <jsp:include page="afternoon.jsp?task=6"/>
    <jsp:include page="evening.jsp?task=6"/>

    <jsp:include page="afternoon.jsp"/>
    <jsp:include page="afternoon?task=7" />
    <p>Message from Servlet "afternoon": ${servletMessage}</p>

    <p>Task 8</p>
    <form>
        <input type="hidden" name="task" value="88">
        <input type="submit" value="JSP-forward"/>
    </form>
    <%
        if (request.getParameter("task") != null && request.getParameter("task").equals("88")) {
            if (LocalDateTime.now().getHour() >= 1 && LocalDateTime.now().getHour() <= 6) {
            %>
                <jsp:forward page="night.jsp">
                    <jsp:param name="task" value="8"/>
                </jsp:forward>
            <% } else if (LocalDateTime.now().getHour() >= 7 && LocalDateTime.now().getHour() <= 11) { %>
                <jsp:forward page="morning.jsp">
                    <jsp:param name="task" value="8"/>
                </jsp:forward>
            <% } else if (LocalDateTime.now().getHour() >= 12 && LocalDateTime.now().getHour() <= 17) { %>
                <jsp:forward page="afternoon.jsp">
                    <jsp:param name="task" value="8"/>
                </jsp:forward>
            <% } else if (LocalDateTime.now().getHour() >= 18) { %>
                <jsp:forward page="evening.jsp">
                    <jsp:param name="task" value="8"/>
                </jsp:forward>
        <%}
        }
    %>

    <a href="Jjj?task=11">task 11</a>

    <form action="Jjj" method="get" style="margin-top: 20px">
        <input type="hidden" name="task" value="12"/>
        <input type="submit" value="GET-HttpClient"/>
    </form>

    <form action="Jjj" method="post">
        <input type="submit" value="POST-HttpClient"/>
    </form>
</body>
</html>
