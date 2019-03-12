package com.speedata.uhf.bean;

public class AllNewsBean {

    /**
     * data : {"PM2_5":20,"turbidity":50,"salinity":10,"waterQualityPH":7,"num":1000,"edaTemperature":20,"edaHumidity":20,"DO":10,"airTemperature":"85","conductivity":10,"airHumidity":"80","PM10":20,"soilPH":"205.6"}
     * message : 请求成功
     * state : 1
     */

    private DataBean data;
    private String message;
    private int state;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public static class DataBean {
        /**
         * PM2_5 : 20
         * turbidity : 50
         * salinity : 10
         * waterQualityPH : 7
         * num : 1000
         * edaTemperature : 20
         * edaHumidity : 20
         * DO : 10
         * airTemperature : 85
         * conductivity : 10
         * airHumidity : 80
         * PM10 : 20
         * soilPH : 205.6
         */

        private String PM2_5;
        private String turbidity;
        private String salinity;
        private String waterQualityPH;
        private String num;
        private String edaTemperature;
        private String edaHumidity;
        private String DO;
        private String airTemperature;
        private String conductivity;
        private String airHumidity;
        private String PM10;
        private String soilPH;

        public String getPM2_5() {
            return PM2_5;
        }

        public void setPM2_5(String PM2_5) {
            this.PM2_5 = PM2_5;
        }

        public String getTurbidity() {
            return turbidity;
        }

        public void setTurbidity(String turbidity) {
            this.turbidity = turbidity;
        }

        public String getSalinity() {
            return salinity;
        }

        public void setSalinity(String salinity) {
            this.salinity = salinity;
        }

        public String getWaterQualityPH() {
            return waterQualityPH;
        }

        public void setWaterQualityPH(String waterQualityPH) {
            this.waterQualityPH = waterQualityPH;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getEdaTemperature() {
            return edaTemperature;
        }

        public void setEdaTemperature(String edaTemperature) {
            this.edaTemperature = edaTemperature;
        }

        public String getEdaHumidity() {
            return edaHumidity;
        }

        public void setEdaHumidity(String edaHumidity) {
            this.edaHumidity = edaHumidity;
        }

        public String getDO() {
            return DO;
        }

        public void setDO(String DO) {
            this.DO = DO;
        }

        public String getAirTemperature() {
            return airTemperature;
        }

        public void setAirTemperature(String airTemperature) {
            this.airTemperature = airTemperature;
        }

        public String getConductivity() {
            return conductivity;
        }

        public void setConductivity(String conductivity) {
            this.conductivity = conductivity;
        }

        public String getAirHumidity() {
            return airHumidity;
        }

        public void setAirHumidity(String airHumidity) {
            this.airHumidity = airHumidity;
        }

        public String getPM10() {
            return PM10;
        }

        public void setPM10(String PM10) {
            this.PM10 = PM10;
        }

        public String getSoilPH() {
            return soilPH;
        }

        public void setSoilPH(String soilPH) {
            this.soilPH = soilPH;
        }
    }
}
