package org.covid.dao;

import org.covid.entity.Province;
import org.covid.util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChinaDao {
    public boolean insertProvince(Province province) {
        String sql = "insert into china values(?,?,?,?,?,?,?)";
        Object[] params = {province.getProvinceName(),province.getProvinceShortName(),province.getConfirmedCount(),province.getCurrentConfirmedCount(),province.getSuspectedCount(),province.getCuredCount(),province.getDeadCount()};
        return DBUtil.executeUpdate(sql, params);
    }

    public boolean clearAllProvince()
    {
        String sql="delete from china";
        Object[] params={};
        return DBUtil.executeUpdate(sql, params);
    }

    public List<Province> queryAllProvince()
    {
        List<Province> provinceList= new ArrayList<>();
        Province province= null;
        String sql= "select * from china order by currentConfirmedCount desc;";
        Object[] params={};
        ResultSet resultSet=null;
        resultSet=DBUtil.executeQuery(sql,params);
        try{
            while(resultSet.next())
            {
                String provinceName=resultSet.getString("provinceName");
                String provinceShortName=resultSet.getString("provinceShortName");
                int currentConfirmedCount=resultSet.getInt("currentConfirmedCount");
                int confirmedCount=resultSet.getInt("confirmedCount");
                int suspectedCount=resultSet.getInt("suspectedCount");
                int curedCount=resultSet.getInt("curedCount");
                int deadCount=resultSet.getInt("deadCount");
                province= new Province(provinceName,provinceShortName,currentConfirmedCount,confirmedCount,suspectedCount,curedCount,deadCount);
                provinceList.add(province);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return provinceList;
    }
}
