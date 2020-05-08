<%@ page import="org.covid.entity.Province" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html style="height:100%;">
<head>
    <title>中国疫情</title>
    <meta charset="utf-8">
    <script src="js/echarts.js"></script>
    <script src="js/china.js"></script>
    <script>
        var mydata=[]
    </script>

    <%
        List<Province> provinceList=(List<Province>)request.getAttribute("provinceList");
        for (Province province : provinceList) {
    %>
    <script>
        var provinceName = "<%=province.getProvinceShortName()%>";
        var values = [];
        values.push("<%=province.getCurrentConfirmedCount()%>")
        values.push("<%=province.getConfirmedCount()%>")
        values.push("<%=province.getSuspectedCount()%>")
        values.push("<%=province.getCuredCount()%>")
        values.push("<%=province.getDeadCount()%>")
        mydata.push({name: provinceName, value: values})
    </script>
    <%
        }
    %>
</head>
<body style="height:100%;">
<a href="index.jsp">首页</a>
<a href="WorldServlet">世界疫情</a>
<a href="https://new.qq.com/omn/20200310/20200310A066S000.html?pc">防疫常识</a>
<a href="https://www.baidu.com/index.php?tn=monline_3_dg">百度</a>

<div id="main" style="width:100%;height:100%;"></div>
<br/>
<br/>
<br/>
<div id="pieChart" style="width:100%;height:100%;"></div>
<br/><br/><br/><br/><br/><br/>
<table border="1px"  align="center"  cellpadding="20" bgcolor="#faebd7" >
    <tr>
        <th>省份</th>
        <th>现有确诊</th>
        <th>累计确诊</th>
        <th>疑似人口</th>
        <th>治愈人口</th>
        <th>死亡人口</th>
    </tr>

    <%
        for (Province province : provinceList) {
    %>
    <tr>
        <td><a href="QueryAllCitiesByProvinceServlet?provinceName=<%=province.getProvinceName() %>"><%=province.getProvinceName() %></td>
        <td><%=province.getCurrentConfirmedCount() %></td>
        <td><%=province.getConfirmedCount() %></td>
        <td><%=province.getSuspectedCount() %></td>
        <td><%=province.getCuredCount() %></td>
        <td><%=province.getDeadCount() %></td>
    </tr>

    <%
        }
    %>

</table>


<script>
    var option = {
        backgroundColor: '#ffffff',
        title: {
            text: '全国疫情数据',
            x:'center'
        },
        tooltip : {//鼠标在城市显示
            trigger: 'item',
            formatter(params) {
                return params.name + '<br/>'
                    + '现有确诊 : ' +params.data.value[0]+'<br/>'
                    + '累计确诊 : ' + params.data.value[1] + '<br/>'
                    + '疑似病例 : ' + params.data.value[2] + '<br/>'
                    + '治愈人数 : ' + params.data.value[3] + '<br/>'
                    + '死亡人数 : ' + params.data.value[4] + '<br/>'
            },

        },
        visualMap: {
            show : false,
            x: 'left',
            y: 'bottom',
            dimension:0,
            seriesIndex:0,
            splitList: [
                {start: 500, end:1000},{start: 100, end: 500},
                {start: 50, end: 100},{start: 10, end: 50},
                {start: 1, end: 10},{start: 0, end: 1},
            ],
            color: ['#F99003', '#FCA632', '#FBB556','#F9C57D', '#FBDDB4', '#FBF6EF']
        },
        series: [
            {
                name: '疫情数据',
                type: 'map',
                mapType: 'china',
                roam: false,//bu能移动
                label: {
                    normal: {
                        show: true,//显示各省份标签
                        textStyle:{
                            color: "black"
                        }//字体颜色
                    },
                    emphasis: {
                        show: false
                    }
                },

                aspectScale: 0.75,//这个参数用于 scale 地图的长宽比。最终的 aspect 的计算方式是：geoBoundingRect.width / geoBoundingRect.height * aspectScale
                zoom: 1.2,//当前视角的缩放比例。
                data:mydata
            }
        ]
    };
    var chart = echarts.init(document.getElementById('main'));
    chart.setOption(option);
</script>

<script>
    option = {
        title: {
            text: '中国疫情',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter(params) {
                return params.name + '<br/>'
                    + '现有确诊 : ' +params.data.value[0]+'<br/>'
                    + '累计确诊 : ' + params.data.value[1] + '<br/>'
                    + '疑似病例 : ' + params.data.value[2] + '<br/>'
                    + '治愈人数 : ' + params.data.value[3] + '<br/>'
                    + '死亡人数 : ' + params.data.value[4] + '<br/>'
            },
        },
        legend: {
            orient: 'vertical',
            left: 'left',
        },
        series: [
            {
                type: 'pie',
                radius: '80%',
                center: ['50%', '60%'],
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


</body>
</html>
