package org.covid.servlet;

import org.covid.entity.City;
import org.covid.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet("/QueryAllCitiesByProvinceServlet")
public class QueryAllCitiesByProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String provinceName=(String)request.getParameter("provinceName");
        CityService cityService= new CityService();
        List<City> cityList=cityService.queryAllCitiesByProvince(provinceName);
        request.setAttribute("cityList",cityList);
        request.getRequestDispatcher("city.jsp").forward(request,response);
    }
}
