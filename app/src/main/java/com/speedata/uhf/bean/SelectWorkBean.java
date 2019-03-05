package com.speedata.uhf.bean;

import java.util.List;

public class SelectWorkBean {

    /**
     * data : {"PageInfo":{"endRow":5,"firstPage":1,"hasNextPage":false,"hasPreviousPage":false,"isFirstPage":true,"isLastPage":true,"lastPage":1,"list":[{"WORK_NAME":"补植","STATUS":"1","WORK_CODE":"f","CONSERVATION_CODE":"ocoHcQOR","ROW_ID":1},{"WORK_NAME":"其他","STATUS":"1","WORK_CODE":"h","CONSERVATION_CODE":"D6r35mwU","ROW_ID":2},{"WORK_NAME":"修剪","STATUS":"1","WORK_CODE":"d","CONSERVATION_CODE":"MS0hbwNP","ROW_ID":3},{"WORK_NAME":"排涝","STATUS":"1","WORK_CODE":"e","CONSERVATION_CODE":"lKARHMGg","ROW_ID":4},{"WORK_NAME":"除草","STATUS":"1","WORK_CODE":"b","CONSERVATION_CODE":"3XMDZdHp","ROW_ID":5}],"navigatePages":8,"navigatepageNums":[1],"nextPage":0,"pageNum":1,"pageSize":8,"pages":1,"prePage":0,"size":5,"startRow":1,"total":5}}
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
         * PageInfo : {"endRow":5,"firstPage":1,"hasNextPage":false,"hasPreviousPage":false,"isFirstPage":true,"isLastPage":true,"lastPage":1,"list":[{"WORK_NAME":"补植","STATUS":"1","WORK_CODE":"f","CONSERVATION_CODE":"ocoHcQOR","ROW_ID":1},{"WORK_NAME":"其他","STATUS":"1","WORK_CODE":"h","CONSERVATION_CODE":"D6r35mwU","ROW_ID":2},{"WORK_NAME":"修剪","STATUS":"1","WORK_CODE":"d","CONSERVATION_CODE":"MS0hbwNP","ROW_ID":3},{"WORK_NAME":"排涝","STATUS":"1","WORK_CODE":"e","CONSERVATION_CODE":"lKARHMGg","ROW_ID":4},{"WORK_NAME":"除草","STATUS":"1","WORK_CODE":"b","CONSERVATION_CODE":"3XMDZdHp","ROW_ID":5}],"navigatePages":8,"navigatepageNums":[1],"nextPage":0,"pageNum":1,"pageSize":8,"pages":1,"prePage":0,"size":5,"startRow":1,"total":5}
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
             * endRow : 5
             * firstPage : 1
             * hasNextPage : false
             * hasPreviousPage : false
             * isFirstPage : true
             * isLastPage : true
             * lastPage : 1
             * list : [{"WORK_NAME":"补植","STATUS":"1","WORK_CODE":"f","CONSERVATION_CODE":"ocoHcQOR","ROW_ID":1},{"WORK_NAME":"其他","STATUS":"1","WORK_CODE":"h","CONSERVATION_CODE":"D6r35mwU","ROW_ID":2},{"WORK_NAME":"修剪","STATUS":"1","WORK_CODE":"d","CONSERVATION_CODE":"MS0hbwNP","ROW_ID":3},{"WORK_NAME":"排涝","STATUS":"1","WORK_CODE":"e","CONSERVATION_CODE":"lKARHMGg","ROW_ID":4},{"WORK_NAME":"除草","STATUS":"1","WORK_CODE":"b","CONSERVATION_CODE":"3XMDZdHp","ROW_ID":5}]
             * navigatePages : 8
             * navigatepageNums : [1]
             * nextPage : 0
             * pageNum : 1
             * pageSize : 8
             * pages : 1
             * prePage : 0
             * size : 5
             * startRow : 1
             * total : 5
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
                 * WORK_NAME : 补植
                 * STATUS : 1
                 * WORK_CODE : f
                 * CONSERVATION_CODE : ocoHcQOR
                 * ROW_ID : 1
                 */

                private String WORK_NAME;
                private String STATUS;
                private String WORK_CODE;
                private String CONSERVATION_CODE;
                private int ROW_ID;

                public String getWORK_NAME() {
                    return WORK_NAME;
                }

                public void setWORK_NAME(String WORK_NAME) {
                    this.WORK_NAME = WORK_NAME;
                }

                public String getSTATUS() {
                    return STATUS;
                }

                public void setSTATUS(String STATUS) {
                    this.STATUS = STATUS;
                }

                public String getWORK_CODE() {
                    return WORK_CODE;
                }

                public void setWORK_CODE(String WORK_CODE) {
                    this.WORK_CODE = WORK_CODE;
                }

                public String getCONSERVATION_CODE() {
                    return CONSERVATION_CODE;
                }

                public void setCONSERVATION_CODE(String CONSERVATION_CODE) {
                    this.CONSERVATION_CODE = CONSERVATION_CODE;
                }

                public int getROW_ID() {
                    return ROW_ID;
                }

                public void setROW_ID(int ROW_ID) {
                    this.ROW_ID = ROW_ID;
                }
            }
        }
    }
}
