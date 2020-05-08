<%@ page import="java.util.List" %>
<%@ page import="org.covid.entity.City" %><%--
  Created by IntelliJ IDEA.
  User: 29057
  Date: 2020/5/6
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CityInformation</title>
</head>
<body>

<%
    List<City> cityList= (List<City>)request.getAttribute("cityList");
%>
<a href="index.jsp">首页</a>
<a href="ChinaServlet">返回</a>
<a href="https://new.qq.com/omn/20200310/20200310A066S000.html?pc">防疫常识</a>
<a href="https://www.baidu.com/index.php?tn=monline_3_dg">百度</a>

<table border="1px"  align="center"  cellpadding="30" bgcolor="#faebd7" >
    <tr>
        <th>城市</th>
        <th>现有确诊</th>
        <th>累计确诊</th>
        <th>疑似人口</th>
        <th>治愈人口</th>
        <th>死亡人口</th>
    </tr>

    <%
        for (City city : cityList) {
    %>
    <tr>
        <td><%=city.getCityName() %></td>
        <td><%=city.getCurrentConfirmedCount() %></td>
        <td><%=city.getConfirmedCount() %></td>
        <td><%=city.getSuspectedCount() %></td>
        <td><%=city.getCuredCount() %></td>
        <td><%=city.getDeadCount() %></td>
    </tr>

    <%
        }
    %>

</table>


</body>
</html>
