package org.covid.dao;
import org.covid.entity.Country;
import org.covid.util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WorldDao {
    DBUtil dbUtil= new DBUtil();
    public boolean insertCountry(Country country) {
        String sql = "insert into world values(?,?,?,?,?,?)";
        Object[] params = {country.getCountryName(),country.getContinent(),country.getCurrentConfirmedCount(),country.getConfirmedCount(),country.getCuredCount(),country.getDeadCount(),};
        return DBUtil.executeUpdate(sql, params);
    }

    public boolean clearAllCountry()
    {
        String sql="delete from world";
        Object[] params={};
        return DBUtil.executeUpdate(sql, params);
    }

    public List<Country> queryAllCountry()
    {
        Country country=null;
        List<Country> countries= new ArrayList<>();
        String sql="select * from world order by currentConfirmedCount desc;";
        Object[] params={};
        ResultSet resultSet=DBUtil.executeQuery(sql,params);
        try {
            while (resultSet.next()) {
                String countryName=resultSet.getString("countryName");
                String continent=resultSet.getString("continent");
                int currentConfirmedCount=resultSet.getInt("currentConfirmedCount");
                int confirmedCount=resultSet.getInt("confirmedCount");
                int curedCount=resultSet.getInt("curedCount");
                int deadCount=resultSet.getInt("deadCount");
                country=new Country(countryName,continent,currentConfirmedCount,confirmedCount,curedCount,deadCount);
                countries.add(country);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return countries;
    }
}
