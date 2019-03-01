package com.speedata.uhf.bean;

import java.util.List;

public class YanghuBean {


    /**
     * data : [{"WORK_NAME":"施肥","NUM":1},{"WORK_NAME":"补植","NUM":0},{"WORK_NAME":"病虫危害防治","NUM":0},{"WORK_NAME":"其他","NUM":0},{"WORK_NAME":"修剪","NUM":0},{"WORK_NAME":"排涝","NUM":0},{"WORK_NAME":"浇水","NUM":1},{"WORK_NAME":"除草","NUM":0}]
     * message : 请求成功
     * state : 1
     */

    private String message;
    private int state;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * WORK_NAME : 施肥
         * NUM : 1
         */

        private String WORK_NAME;
        private int NUM;

        public String getWORK_NAME() {
            return WORK_NAME;
        }

        public void setWORK_NAME(String WORK_NAME) {
            this.WORK_NAME = WORK_NAME;
        }

        public int getNUM() {
            return NUM;
        }

        public void setNUM(int NUM) {
            this.NUM = NUM;
        }
    }
}
