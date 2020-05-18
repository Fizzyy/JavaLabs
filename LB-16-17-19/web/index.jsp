<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <p><b>LB-16</b></p>
    <p>URL1: <%=pageContext.getServletContext().getInitParameter("URL1")%></p>
    <p>URL2: <%=pageContext.getServletContext().getInitParameter("URL2")%></p>

    <form action="firstServlet" method="get">
      <label>URLn: <input type="text" name="urln"/></label>
      <input type="submit"/>
    </form>

    <form action="Ccc" method="post">
      <div>
          <label>Value1 <input type="text" name="Value1"/></label>
      </div>
      <div>
          <label>Value2 <input type="text" name="Value2"/></label>
      </div>
      <div>
          <label>Value3 <input type="text" name="Value3"/></label>
      </div>
      <div>
        <label><input type="radio" name="CBean" value="new"/>New</label>
        <label><input type="radio" name="CBean" value="old"/>Old</label>
      </div>
      <input type="submit" value="Send"/>
    </form>

    <p><b>LB-17</b></p>
    <form action="Ccc" method="get">
      <div>
        <label>Value1 <input type="text" name="Value1"/></label>
      </div>
      <div>
        <label>Value2 <input type="text" name="Value2"/></label>
      </div>
      <div>
        <label>Value3 <input type="text" name="Value3"/></label>
      </div>
      <div>
        <label><input type="radio" name="typee" value="request"/>Request</label>
        <label><input type="radio" name="typee" value="session"/>Session</label>
      </div>
      <div>
        <label><input type="radio" name="CBean" value="new"/>New</label>
        <label><input type="radio" name="CBean" value="old"/>Old</label>
      </div>
      <input type="submit" value="Send"/>
    </form>

    <p><b>LB-19</b></p>
    <p>Filters</p>
    <div style="display: flex; flex-direction: column">
      <form action="Ccc.jsp" method="get">
        <label>error parameter: <input type="text" name="error"/></label>
        <button type="submit">check Ccc.jsp</button>
      </form>
      <form action="Ccc" method="get">
        <label>error parameter: <input type="text" name="error"/></label>
        <button type="submit">check Ccc</button>
      </form>
    </div>
    <p>Event Listeners</p>
    <form method="get" action="Ccc">
      <button type="submit" name="listener" value="add">Add attribute</button>
      <button type="submit" name="listener" value="replace">Replace attribute</button>
      <button type="submit" name="listener" value="remove">Remove attribute</button>
    </form>
  </body>
</html>