package com.speedata.uhf.bean;

public class SearchTreesZhongzhiinfoBean {

    /**
     * data : {"TREE_OWNER":"123","AREAS_CODE":"11","GROWTH_STATE":1,"BLOCK_NAME":"A11区块","TENDERS":"1标段","BLOCK_CODE":"111","CREATE_TIME":"2019-02-27 13:51:21","AREAS_NAME":"A1"}
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
         * AREAS_CODE : 11
         * GROWTH_STATE : 1
         * BLOCK_NAME : A11区块
         * TENDERS : 1标段
         * BLOCK_CODE : 111
         * CREATE_TIME : 2019-02-27 13:51:21
         * AREAS_NAME : A1
         */

        private String TREE_OWNER;
        private String AREAS_CODE;
        private int GROWTH_STATE;
        private String BLOCK_NAME;
        private String TENDERS;
        private String BLOCK_CODE;
        private String CREATE_TIME;
        private String AREAS_NAME;

        public String getTREE_OWNER() {
            return TREE_OWNER;
        }

        public void setTREE_OWNER(String TREE_OWNER) {
            this.TREE_OWNER = TREE_OWNER;
        }

        public String getAREAS_CODE() {
            return AREAS_CODE;
        }

        public void setAREAS_CODE(String AREAS_CODE) {
            this.AREAS_CODE = AREAS_CODE;
        }

        public int getGROWTH_STATE() {
            return GROWTH_STATE;
        }

        public void setGROWTH_STATE(int GROWTH_STATE) {
            this.GROWTH_STATE = GROWTH_STATE;
        }

        public String getBLOCK_NAME() {
            return BLOCK_NAME;
        }

        public void setBLOCK_NAME(String BLOCK_NAME) {
            this.BLOCK_NAME = BLOCK_NAME;
        }

        public String getTENDERS() {
            return TENDERS;
        }

        public void setTENDERS(String TENDERS) {
            this.TENDERS = TENDERS;
        }

        public String getBLOCK_CODE() {
            return BLOCK_CODE;
        }

        public void setBLOCK_CODE(String BLOCK_CODE) {
            this.BLOCK_CODE = BLOCK_CODE;
        }

        public String getCREATE_TIME() {
            return CREATE_TIME;
        }

        public void setCREATE_TIME(String CREATE_TIME) {
            this.CREATE_TIME = CREATE_TIME;
        }

        public String getAREAS_NAME() {
            return AREAS_NAME;
        }

        public void setAREAS_NAME(String AREAS_NAME) {
            this.AREAS_NAME = AREAS_NAME;
        }
    }
}
