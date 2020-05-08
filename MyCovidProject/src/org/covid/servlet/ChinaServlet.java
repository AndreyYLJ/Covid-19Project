package org.covid.servlet;

import org.covid.entity.Province;
import org.covid.service.ProvinceService;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@javax.servlet.annotation.WebServlet("/ChinaServlet")
public class ChinaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ProvinceService provinceService= new ProvinceService();
        List<Province> provinceList = provinceService.queryAllProvince();
        request.setAttribute("provinceList",provinceList);
        request.getRequestDispatcher("china.jsp").forward(request, response);
    }
}