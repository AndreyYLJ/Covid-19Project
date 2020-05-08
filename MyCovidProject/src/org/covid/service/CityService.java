package org.covid.service;

import org.covid.dao.CityDao;
import org.covid.entity.City;

import java.util.Iterator;
import java.util.List;

public class CityService {
    CityDao cityDao = new CityDao();
    public boolean addCity(List<City> cities)
    {
        Iterator<City> iterator =cities.iterator();
        while (iterator.hasNext())
            if (!cityDao.insertCity(iterator.next()))
                return false;
        return  true;
    }
    public boolean updateAllCity(List<City> cities)
    {
        if(!cityDao.clearAllCities())
            return false;
        return addCity(cities);
    }

    public List<City> queryAllCitiesByProvince(String provinceName)
    {
        return cityDao.queryAllCitiesByProvince(provinceName);
    }
}
