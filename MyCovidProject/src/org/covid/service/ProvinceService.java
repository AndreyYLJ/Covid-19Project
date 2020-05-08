package org.covid.service;

import org.covid.dao.ChinaDao;
import org.covid.entity.Province;

import java.util.Iterator;
import java.util.List;

public class ProvinceService {
    ChinaDao chinaDao=new ChinaDao();
    public boolean addProvince(List<Province> provinces)//增加国家信息
    {
        Iterator<Province> iterator =provinces.iterator();
        while (iterator.hasNext())
            if (!chinaDao.insertProvince(iterator.next()))
                return false;
        return  true;
    }
    public boolean updateAllProvince(List<Province> provinces)
    {
        if(!chinaDao.clearAllProvince())
            return false;
        return addProvince(provinces);
    }

    public List<Province> queryAllProvince() {
        return chinaDao.queryAllProvince();
    }

}
