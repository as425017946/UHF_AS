package com.speedata.uhf.bean;

public class SearchTreesStateBean {

    /**
     * data : {"TREE_OWNER":"123","GROWTH_STATE":1}
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
         * TREE_OWNER : 123
         * GROWTH_STATE : 1
         */

        private String TREE_OWNER;
        private int GROWTH_STATE;

        public String getTREE_OWNER() {
            return TREE_OWNER;
        }

        public void setTREE_OWNER(String TREE_OWNER) {
            this.TREE_OWNER = TREE_OWNER;
        }

        public int getGROWTH_STATE() {
            return GROWTH_STATE;
        }

        public void setGROWTH_STATE(int GROWTH_STATE) {
            this.GROWTH_STATE = GROWTH_STATE;
        }
    }
}
