<%@ page import="org.covid.entity.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: 29057
  Date: 2020/5/5
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>世界疫情</title>
    <script src="js/echarts.js"></script>
</head>
<body>
<script>
    var mydata=[]
</script>
<%

    List<Country> countryList= (List<Country>)request.getAttribute("countryList");

    Iterator<Country> iterator=countryList.iterator();
    while(iterator.hasNext())
    {
        Country country=iterator.next();
%>
<script>
    var countryName="<%=country.getCountryName()%>";
    var values=[];
    values.push("<%=country.getCurrentConfirmedCount()%>")
    values.push("<%=country.getConfirmedCount()%>")
    values.push("<%=country.getCuredCount()%>")
    values.push("<%=country.getDeadCount()%>")
    mydata.push({name:countryName,value:values})
</script>
<%
    }
%>
<img src="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3224637141,3669251838&fm=15&gp=0.jpg" width='100%' height='30%' >
<a href="index.jsp">首页</a>
<a href="ChinaServlet">中国疫情</a>
<a href="https://new.qq.com/omn/20200310/20200310A066S000.html?pc">防疫常识</a>
<a href="https://www.baidu.com/index.php?tn=monline_3_dg">百度</a>

<br/><br/><br/>
<div id="pieChart" style="width:100%;height:100%;"></div>
<br/><br/><br/>

<script>
    option = {
        title: {
            text: '世界疫情',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter(params) {
                return params.name + '<br/>'
                    + '现有确诊 : ' +params.data.value[0]+'<br/>'
                    + '累计确诊 : ' + params.data.value[1] + '<br/>'
                    + '治愈人数 : ' + params.data.value[2] + '<br/>'
                    + '死亡人数 : ' + params.data.value[3] + '<br/>'
            },
        },
        legend: {
            orient: 'vertical',
            left: 'left',
        },
        series: [
            {
                type: 'pie',
                radius: '70%',
                center: ['70%', '60%'],
                data: mydata,
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
            }

        ]
    };
    var chart = echarts.init(document.getElementById('pieChart'));

    chart.setOption(option);
</script>


<table border="1px"  align="center"  cellpadding="40" bgcolor="#faebd7" >
    <tr>
        <th>国家</th>
        <th>所属大洲</th>
        <th>现有确诊</th>
        <th>累计确诊</th>
        <th>治愈人口</th>
        <th>死亡人口</th>
    </tr>

    <%
        for (Country country : countryList) {
    %>
    <tr>
        <td><%=country.getCountryName() %></td>
        <td><%=country.getContinent() %></td>
        <td><%=country.getCurrentConfirmedCount() %></td>
        <td><%=country.getConfirmedCount() %></td>
        <td><%=country.getCuredCount() %></td>
        <td><%=country.getDeadCount() %></td>
    </tr>

    <%
        }
    %>

</table>

</body>
</html>
