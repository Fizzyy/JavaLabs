<%@ page import="task2.CBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ccc</title>
</head>
<body>
    <%!
        String Type, Value1, Value2, Value3;

        private void getValues(CBean cBean) {
            if (cBean != null) {
                if (cBean.getValue1() != null) {
                    Value1 = cBean.getValue1();
                }
                if (cBean.getValue2() != null) {
                    Value2 = cBean.getValue2();
                }
                if (cBean.getValue3() != null) {
                    Value3 = cBean.getValue3();
                }
            } else if (getServletConfig().getServletContext().getAttribute("oldReq") != null) {
                Value1 = null;
                Value2 = null;
                Value3 = null;
            }
        }
    %>
    <%
        CBean cBean = (CBean)pageContext.getServletContext().getAttribute("atrCbean");
        if (cBean != null) {
            %>
                <p>Type: <%= "Context"%></p>
                <p>Value1: <%= cBean.getValue1()%></p>
                <p>Value2: <%= cBean.getValue2()%></p>
                <p>Value3: <%= cBean.getValue3()%></p>
            <%
        }
    %>
    <%
        String error = request.getParameter("error");

        CBean cBeanRequest = (CBean)request.getAttribute("atrCbeanRequest");
        String oldReq = (String)pageContext.getServletContext().getAttribute("oldReq");
        String newReq = (String)pageContext.getServletContext().getAttribute("newReq");
        if (oldReq != null || newReq != null) {
            %>
                <p>Type: <%= "Request"%></p>
                <p>Value1: <%= cBeanRequest != null ? cBeanRequest.getValue1() : "null"%></p>
                <p>Value2: <%= cBeanRequest != null ? cBeanRequest.getValue2() : "null"%></p>
                <p>Value3: <%= cBeanRequest != null ? cBeanRequest.getValue3() : "null"%></p>
            <%
        }

        CBean cBeanSession = (CBean)session.getAttribute(session.getId());
        if (oldReq == null && newReq == null && error == null) {
            %>
                <p>Type: <%= "Session"%></p>
                <p>Value1: <%= cBeanSession != null ? cBeanSession.getValue1() : "null"%></p>
                <p>Value2: <%= cBeanSession != null ? cBeanSession.getValue2() : "null"%></p>
                <p>Value3: <%= cBeanSession != null ? cBeanSession.getValue3() : "null"%></p>
                <p>Session: <%= request.getSession().getId()%></p>
            <%
        }
    %>
    <%
        if (error != null) {
            response.setContentType("text/html");
            response.getWriter().write("<p>Ccc.jsp has been called</p>");
        }
    %>
</body>
</html>
