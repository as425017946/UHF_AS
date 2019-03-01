package com.speedata.uhf.bean;

public class LoginBean {

    /**
     * data : {"GROUP_NAME":"3组","ACCOUNT":"123456","STATUS":1,"USER_NO":"001","PASSWORD":"e10adc3949ba59abbe56e057f20f883e","GROUP_NO":"6448","USER_PHOTO":"1551246039.jpg","NAME":"孟德斌"}
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
         * GROUP_NAME : 3组
         * ACCOUNT : 123456
         * STATUS : 1
         * USER_NO : 001
         * PASSWORD : e10adc3949ba59abbe56e057f20f883e
         * GROUP_NO : 6448
         * USER_PHOTO : 1551246039.jpg
         * NAME : 孟德斌
         */

        private String GROUP_NAME;
        private String ACCOUNT;
        private int STATUS;
        private String USER_NO;
        private String PASSWORD;
        private String GROUP_NO;
        private String USER_PHOTO;
        private String NAME;

        public String getGROUP_NAME() {
            return GROUP_NAME;
        }

        public void setGROUP_NAME(String GROUP_NAME) {
            this.GROUP_NAME = GROUP_NAME;
        }

        public String getACCOUNT() {
            return ACCOUNT;
        }

        public void setACCOUNT(String ACCOUNT) {
            this.ACCOUNT = ACCOUNT;
        }

        public int getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(int STATUS) {
            this.STATUS = STATUS;
        }

        public String getUSER_NO() {
            return USER_NO;
        }

        public void setUSER_NO(String USER_NO) {
            this.USER_NO = USER_NO;
        }

        public String getPASSWORD() {
            return PASSWORD;
        }

        public void setPASSWORD(String PASSWORD) {
            this.PASSWORD = PASSWORD;
        }

        public String getGROUP_NO() {
            return GROUP_NO;
        }

        public void setGROUP_NO(String GROUP_NO) {
            this.GROUP_NO = GROUP_NO;
        }

        public String getUSER_PHOTO() {
            return USER_PHOTO;
        }

        public void setUSER_PHOTO(String USER_PHOTO) {
            this.USER_PHOTO = USER_PHOTO;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }
    }
}
