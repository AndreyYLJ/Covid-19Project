package org.covid.service;

import org.covid.dao.WorldDao;
import org.covid.entity.Country;

import java.util.Iterator;
import java.util.List;

public class CountryService {
    WorldDao worldDao=new WorldDao();
    public boolean addCountry(List<Country> countries)//增加国家信息
    {

        Iterator<Country> iterator =countries.iterator();
        while (iterator.hasNext())
            if (!worldDao.insertCountry(iterator.next()))
                return false;
            return  true;
    }
    public boolean updateAllCountry(List<Country> countries)
    {

        if(!worldDao.clearAllCountry())
            return false;
        return addCountry(countries);
    }

    public List<Country> QueryAllCountry()
    {
        return worldDao.queryAllCountry();
    }

}
