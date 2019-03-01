package com.speedata.uhf.bean;

import java.util.List;

public class MessagesBean {

    /**
     * data : {"PageInfo":{"endRow":2,"firstPage":1,"hasNextPage":true,"hasPreviousPage":false,"isFirstPage":true,"isLastPage":false,"lastPage":6,"list":[{"CONSERVATION_PHOTO":"1.jpg","START_TIME":"2019-02-14 13:34:00","WORK_CODE":"b","BLOCK_CODE":"211","TENDERS":"2标段","ROW_ID":1,"GROUP_NAME":"3组","CONSERVATION_NAME":"除草      ","NOTES":"3","PAD_USER_NAME":"RR","STATUS":"2","CONSERVATION_WORK":"a","GROWTH_STATE":1,"END_TIME":"2019-02-14 13:34:03","USER_PHOTO":"1551320922.jpg","CONSERVATION_CODE":"d","GROUP_CODE":"6448","CREATE_TIME":"2019-02-14 13:33:13"},{"CONSERVATION_PHOTO":"1.jpg","START_TIME":"2019-02-14 13:34:00","WORK_CODE":"b","BLOCK_CODE":"211","TENDERS":"2标段","ROW_ID":2,"GROUP_NAME":"6组","CONSERVATION_NAME":"浇水      ","NOTES":"1","PAD_USER_NAME":"RR","STATUS":"1","CONSERVATION_WORK":"浇水  ","GROWTH_STATE":1,"END_TIME":"2019-02-14 13:34:03","USER_PHOTO":"1551320922.jpg","CONSERVATION_CODE":"e","GROUP_CODE":"0917","CREATE_TIME":"2019-02-14 13:33:13"}],"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6],"nextPage":2,"pageNum":1,"pageSize":2,"pages":6,"prePage":0,"size":2,"startRow":1,"total":11}}
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
         * PageInfo : {"endRow":2,"firstPage":1,"hasNextPage":true,"hasPreviousPage":false,"isFirstPage":true,"isLastPage":false,"lastPage":6,"list":[{"CONSERVATION_PHOTO":"1.jpg","START_TIME":"2019-02-14 13:34:00","WORK_CODE":"b","BLOCK_CODE":"211","TENDERS":"2标段","ROW_ID":1,"GROUP_NAME":"3组","CONSERVATION_NAME":"除草      ","NOTES":"3","PAD_USER_NAME":"RR","STATUS":"2","CONSERVATION_WORK":"a","GROWTH_STATE":1,"END_TIME":"2019-02-14 13:34:03","USER_PHOTO":"1551320922.jpg","CONSERVATION_CODE":"d","GROUP_CODE":"6448","CREATE_TIME":"2019-02-14 13:33:13"},{"CONSERVATION_PHOTO":"1.jpg","START_TIME":"2019-02-14 13:34:00","WORK_CODE":"b","BLOCK_CODE":"211","TENDERS":"2标段","ROW_ID":2,"GROUP_NAME":"6组","CONSERVATION_NAME":"浇水      ","NOTES":"1","PAD_USER_NAME":"RR","STATUS":"1","CONSERVATION_WORK":"浇水  ","GROWTH_STATE":1,"END_TIME":"2019-02-14 13:34:03","USER_PHOTO":"1551320922.jpg","CONSERVATION_CODE":"e","GROUP_CODE":"0917","CREATE_TIME":"2019-02-14 13:33:13"}],"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6],"nextPage":2,"pageNum":1,"pageSize":2,"pages":6,"prePage":0,"size":2,"startRow":1,"total":11}
         */

        private PageInfoBean PageInfo;

        public PageInfoBean getPageInfo() {
            return PageInfo;
        }

        public void setPageInfo(PageInfoBean PageInfo) {
            this.PageInfo = PageInfo;
        }

        public static class PageInfoBean {
            /**
             * endRow : 2
             * firstPage : 1
             * hasNextPage : true
             * hasPreviousPage : false
             * isFirstPage : true
             * isLastPage : false
             * lastPage : 6
             * list : [{"CONSERVATION_PHOTO":"1.jpg","START_TIME":"2019-02-14 13:34:00","WORK_CODE":"b","BLOCK_CODE":"211","TENDERS":"2标段","ROW_ID":1,"GROUP_NAME":"3组","CONSERVATION_NAME":"除草      ","NOTES":"3","PAD_USER_NAME":"RR","STATUS":"2","CONSERVATION_WORK":"a","GROWTH_STATE":1,"END_TIME":"2019-02-14 13:34:03","USER_PHOTO":"1551320922.jpg","CONSERVATION_CODE":"d","GROUP_CODE":"6448","CREATE_TIME":"2019-02-14 13:33:13"},{"CONSERVATION_PHOTO":"1.jpg","START_TIME":"2019-02-14 13:34:00","WORK_CODE":"b","BLOCK_CODE":"211","TENDERS":"2标段","ROW_ID":2,"GROUP_NAME":"6组","CONSERVATION_NAME":"浇水      ","NOTES":"1","PAD_USER_NAME":"RR","STATUS":"1","CONSERVATION_WORK":"浇水  ","GROWTH_STATE":1,"END_TIME":"2019-02-14 13:34:03","USER_PHOTO":"1551320922.jpg","CONSERVATION_CODE":"e","GROUP_CODE":"0917","CREATE_TIME":"2019-02-14 13:33:13"}]
             * navigatePages : 8
             * navigatepageNums : [1,2,3,4,5,6]
             * nextPage : 2
             * pageNum : 1
             * pageSize : 2
             * pages : 6
             * prePage : 0
             * size : 2
             * startRow : 1
             * total : 11
             */

            private int endRow;
            private int firstPage;
            private boolean hasNextPage;
            private boolean hasPreviousPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private int lastPage;
            private int navigatePages;
            private int nextPage;
            private int pageNum;
            private int pageSize;
            private int pages;
            private int prePage;
            private int size;
            private int startRow;
            private int total;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getFirstPage() {
                return firstPage;
            }

            public void setFirstPage(int firstPage) {
                this.firstPage = firstPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * CONSERVATION_PHOTO : 1.jpg
                 * START_TIME : 2019-02-14 13:34:00
                 * WORK_CODE : b
                 * BLOCK_CODE : 211
                 * TENDERS : 2标段
                 * ROW_ID : 1
                 * GROUP_NAME : 3组
                 * CONSERVATION_NAME : 除草
                 * NOTES : 3
                 * PAD_USER_NAME : RR
                 * STATUS : 2
                 * CONSERVATION_WORK : a
                 * GROWTH_STATE : 1
                 * END_TIME : 2019-02-14 13:34:03
                 * USER_PHOTO : 1551320922.jpg
                 * CONSERVATION_CODE : d
                 * GROUP_CODE : 6448
                 * CREATE_TIME : 2019-02-14 13:33:13
                 */

                private String CONSERVATION_PHOTO;
                private String START_TIME;
                private String WORK_CODE;
                private String BLOCK_CODE;
                private String TENDERS;
                private int ROW_ID;
                private String GROUP_NAME;
                private String CONSERVATION_NAME;
                private String NOTES;
                private String PAD_USER_NAME;
                private String STATUS;
                private String CONSERVATION_WORK;
                private int GROWTH_STATE;
                private String END_TIME;
                private String USER_PHOTO;
                private String CONSERVATION_CODE;
                private String GROUP_CODE;
                private String CREATE_TIME;

                public String getCONSERVATION_PHOTO() {
                    return CONSERVATION_PHOTO;
                }

                public void setCONSERVATION_PHOTO(String CONSERVATION_PHOTO) {
                    this.CONSERVATION_PHOTO = CONSERVATION_PHOTO;
                }

                public String getSTART_TIME() {
                    return START_TIME;
                }

                public void setSTART_TIME(String START_TIME) {
                    this.START_TIME = START_TIME;
                }

                public String getWORK_CODE() {
                    return WORK_CODE;
                }

                public void setWORK_CODE(String WORK_CODE) {
                    this.WORK_CODE = WORK_CODE;
                }

                public String getBLOCK_CODE() {
                    return BLOCK_CODE;
                }

                public void setBLOCK_CODE(String BLOCK_CODE) {
                    this.BLOCK_CODE = BLOCK_CODE;
                }

                public String getTENDERS() {
                    return TENDERS;
                }

                public void setTENDERS(String TENDERS) {
                    this.TENDERS = TENDERS;
                }

                public int getROW_ID() {
                    return ROW_ID;
                }

                public void setROW_ID(int ROW_ID) {
                    this.ROW_ID = ROW_ID;
                }

                public String getGROUP_NAME() {
                    return GROUP_NAME;
                }

                public void setGROUP_NAME(String GROUP_NAME) {
                    this.GROUP_NAME = GROUP_NAME;
                }

                public String getCONSERVATION_NAME() {
                    return CONSERVATION_NAME;
                }

                public void setCONSERVATION_NAME(String CONSERVATION_NAME) {
                    this.CONSERVATION_NAME = CONSERVATION_NAME;
                }

                public String getNOTES() {
                    return NOTES;
                }

                public void setNOTES(String NOTES) {
                    this.NOTES = NOTES;
                }

                public String getPAD_USER_NAME() {
                    return PAD_USER_NAME;
                }

                public void setPAD_USER_NAME(String PAD_USER_NAME) {
                    this.PAD_USER_NAME = PAD_USER_NAME;
                }

                public String getSTATUS() {
                    return STATUS;
                }

                public void setSTATUS(String STATUS) {
                    this.STATUS = STATUS;
                }

                public String getCONSERVATION_WORK() {
                    return CONSERVATION_WORK;
                }

                public void setCONSERVATION_WORK(String CONSERVATION_WORK) {
                    this.CONSERVATION_WORK = CONSERVATION_WORK;
                }

                public int getGROWTH_STATE() {
                    return GROWTH_STATE;
                }

                public void setGROWTH_STATE(int GROWTH_STATE) {
                    this.GROWTH_STATE = GROWTH_STATE;
                }

                public String getEND_TIME() {
                    return END_TIME;
                }

                public void setEND_TIME(String END_TIME) {
                    this.END_TIME = END_TIME;
                }

                public String getUSER_PHOTO() {
                    return USER_PHOTO;
                }

                public void setUSER_PHOTO(String USER_PHOTO) {
                    this.USER_PHOTO = USER_PHOTO;
                }

                public String getCONSERVATION_CODE() {
                    return CONSERVATION_CODE;
                }

                public void setCONSERVATION_CODE(String CONSERVATION_CODE) {
                    this.CONSERVATION_CODE = CONSERVATION_CODE;
                }

                public String getGROUP_CODE() {
                    return GROUP_CODE;
                }

                public void setGROUP_CODE(String GROUP_CODE) {
                    this.GROUP_CODE = GROUP_CODE;
                }

                public String getCREATE_TIME() {
                    return CREATE_TIME;
                }

                public void setCREATE_TIME(String CREATE_TIME) {
                    this.CREATE_TIME = CREATE_TIME;
                }
            }
        }
    }
}
