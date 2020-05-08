package org.covid.servlet;

import org.covid.entity.Country;
import org.covid.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet("/WorldServlet")

public class WorldServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        CountryService countryService = new CountryService();
        List<Country> countryList=countryService.QueryAllCountry();
        request.setAttribute("countryList",countryList);
        request.getRequestDispatcher("world.jsp").forward(request, response);
    }
}
