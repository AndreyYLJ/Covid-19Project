package org.covid.entity;

import java.util.ArrayList;
import java.util.List;

public class ProvinceAndCity {
    List<Province> provinces;
    List<City> cities;

    public ProvinceAndCity(List<Province> provinces, List<City> cities) {
        this.provinces = provinces;
        this.cities = cities;
    }

    public ProvinceAndCity() {
        this.provinces=new ArrayList<Province>();
        this.cities=new ArrayList<City>();
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
