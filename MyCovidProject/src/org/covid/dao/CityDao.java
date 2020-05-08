package org.covid.dao;

import org.covid.entity.City;
import org.covid.util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
    public boolean insertCity(City city) {
        String sql = "insert into city values(?,?,?,?,?,?,?)";
        Object[] params = {city.getProvinceName(),city.getCityName(),city.getCurrentConfirmedCount(),city.getConfirmedCount(),city.getSuspectedCount(),city.getCuredCount(),city.getDeadCount()};
        return DBUtil.executeUpdate(sql, params);
    }

    public boolean clearAllCities()
    {
        String sql="delete from city";
        Object[] params={};
        return DBUtil.executeUpdate(sql, params);
    }

    public List<City> queryAllCitiesByProvince(String provinceName)
    {
        List<City> cityList=new ArrayList<>();
        String sql="select * from city where provinceName = ? order by currentConfirmedCount desc;";
        Object[] params={provinceName};
        ResultSet resultSet=DBUtil.executeQuery(sql,params);
        City city=null;
        try{
            while(resultSet.next())
            {
                String cityName=resultSet.getString("cityName");
                int currentConfirmedCount=resultSet.getInt("currentConfirmedCount");
                int confirmedCount=resultSet.getInt("confirmedCount");
                int suspectedCount=resultSet.getInt("suspectedCount");
                int curedCount=resultSet.getInt("curedCount");
                int deadCount=resultSet.getInt("deadCount");
                city = new City(provinceName,cityName,currentConfirmedCount,confirmedCount,suspectedCount,curedCount,deadCount);
                cityList.add(city);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return cityList;
    }

}
