package com.speedata.uhf.bean;

public class SelectRfidBean {
    /**
     * data : {"BLOCK_NAME":"13","BLOCK_CODE":"13"}
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
         * BLOCK_NAME : 13
         * BLOCK_CODE : 13
         */

        private String BLOCK_NAME;
        private String BLOCK_CODE;

        public String getBLOCK_NAME() {
            return BLOCK_NAME;
        }

        public void setBLOCK_NAME(String BLOCK_NAME) {
            this.BLOCK_NAME = BLOCK_NAME;
        }

        public String getBLOCK_CODE() {
            return BLOCK_CODE;
        }

        public void setBLOCK_CODE(String BLOCK_CODE) {
            this.BLOCK_CODE = BLOCK_CODE;
        }
    }
}
