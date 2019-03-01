package com.speedata.uhf.bean;

public class SearchTreeZhiwuinfoBean {

    /**
     * data : {"PRODUCE_CITY":"天津市","TREE_DBH":"1","TREE_MMCD":"1","TREE_AGE":"1","TREE_NO":"iHLDWJkE","TREE_SOILBALL_D":"1","BLOCK_CODE":"111","TREE_NAME":"aa","TREE_SOILBALL_S":"1"}
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
         * TREE_DBH : 1
         * TREE_MMCD : 1
         * TREE_AGE : 1
         * TREE_NO : iHLDWJkE
         * TREE_SOILBALL_D : 1
         * BLOCK_CODE : 111
         * TREE_NAME : aa
         * TREE_SOILBALL_S : 1
         */

        private String PRODUCE_CITY;
        private String TREE_DBH;
        private String TREE_MMCD;
        private String TREE_AGE;
        private String TREE_NO;
        private String TREE_SOILBALL_D;
        private String BLOCK_CODE;
        private String TREE_NAME;
        private String TREE_SOILBALL_S;

        public String getPRODUCE_CITY() {
            return PRODUCE_CITY;
        }

        public void setPRODUCE_CITY(String PRODUCE_CITY) {
            this.PRODUCE_CITY = PRODUCE_CITY;
        }

        public String getTREE_DBH() {
            return TREE_DBH;
        }

        public void setTREE_DBH(String TREE_DBH) {
            this.TREE_DBH = TREE_DBH;
        }

        public String getTREE_MMCD() {
            return TREE_MMCD;
        }

        public void setTREE_MMCD(String TREE_MMCD) {
            this.TREE_MMCD = TREE_MMCD;
        }

        public String getTREE_AGE() {
            return TREE_AGE;
        }

        public void setTREE_AGE(String TREE_AGE) {
            this.TREE_AGE = TREE_AGE;
        }

        public String getTREE_NO() {
            return TREE_NO;
        }

        public void setTREE_NO(String TREE_NO) {
            this.TREE_NO = TREE_NO;
        }

        public String getTREE_SOILBALL_D() {
            return TREE_SOILBALL_D;
        }

        public void setTREE_SOILBALL_D(String TREE_SOILBALL_D) {
            this.TREE_SOILBALL_D = TREE_SOILBALL_D;
        }

        public String getBLOCK_CODE() {
            return BLOCK_CODE;
        }

        public void setBLOCK_CODE(String BLOCK_CODE) {
            this.BLOCK_CODE = BLOCK_CODE;
        }

        public String getTREE_NAME() {
            return TREE_NAME;
        }

        public void setTREE_NAME(String TREE_NAME) {
            this.TREE_NAME = TREE_NAME;
        }

        public String getTREE_SOILBALL_S() {
            return TREE_SOILBALL_S;
        }

        public void setTREE_SOILBALL_S(String TREE_SOILBALL_S) {
            this.TREE_SOILBALL_S = TREE_SOILBALL_S;
        }
    }
}
