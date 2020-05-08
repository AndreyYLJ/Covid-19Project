package org.covid.entity;

public class Province {
    String provinceName;
    String provinceShortName;
    int currentConfirmedCount;
    int confirmedCount;
    int suspectedCount;
    int curedCount;
    int deadCount;

    public Province(String provinceName, String provinceShortName,int currentConfirmedCount, int confirmedCount, int suspectedCount, int curedCount, int deadCount) {
        this.provinceName = provinceName;
        this.provinceShortName=provinceShortName;
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
    }

    public Province() {
    }

    public String getProvinceName() {

        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(int currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public int getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(int confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public int getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(int suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public int getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(int curedCount) {
        this.curedCount = curedCount;
    }

    public int getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(int deadCount) {
        this.deadCount = deadCount;
    }
}
