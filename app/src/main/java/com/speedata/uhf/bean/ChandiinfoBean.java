package com.speedata.uhf.bean;

public class ChandiinfoBean {

    /**
     * data : {"PRODUCE_CITY":"天津市","START_TIME":"2019-02-18 11:20:09","START_LOCATION":"123","PRODUCE_NAME":"天津某某某","GARDEN":"13"}
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
         * PRODUCE_CITY : 天津市
         * START_TIME : 2019-02-18 11:20:09
         * START_LOCATION : 123
         * PRODUCE_NAME : 天津某某某
         * GARDEN : 13
         */

        private String PRODUCE_CITY;
        private String START_TIME;
        private String START_LOCATION;
        private String PRODUCE_NAME;
        private String GARDEN;

        public String getPRODUCE_CITY() {
            return PRODUCE_CITY;
        }

        public void setPRODUCE_CITY(String PRODUCE_CITY) {
            this.PRODUCE_CITY = PRODUCE_CITY;
        }

        public String getSTART_TIME() {
            return START_TIME;
        }

        public void setSTART_TIME(String START_TIME) {
            this.START_TIME = START_TIME;
        }

        public String getSTART_LOCATION() {
            return START_LOCATION;
        }

        public void setSTART_LOCATION(String START_LOCATION) {
            this.START_LOCATION = START_LOCATION;
        }

        public String getPRODUCE_NAME() {
            return PRODUCE_NAME;
        }

        public void setPRODUCE_NAME(String PRODUCE_NAME) {
            this.PRODUCE_NAME = PRODUCE_NAME;
        }

        public String getGARDEN() {
            return GARDEN;
        }

        public void setGARDEN(String GARDEN) {
            this.GARDEN = GARDEN;
        }
    }
}
