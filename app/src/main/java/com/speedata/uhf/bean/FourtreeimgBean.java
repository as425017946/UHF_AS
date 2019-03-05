package com.speedata.uhf.bean;

import java.util.List;

public class FourtreeimgBean {

    /**
     * data : [{"img":"201903041758311.pn"}]
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
         * img : 201903041758311.pn
         */

        private String img;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
