package beans;

import java.util.List;

public class pageBean<T> {
    //当前页码
    private int currentPage;

    //每页显示的条数
    private int pageSize;

    //数据总条数
    private long totalCount;

    //总页数
    private int totalPage;

    //定义一个集合存储每页的数据
    private List<T> list;

    public pageBean() {
    }

    public pageBean(int currentPage, int pageSize, long totalCount, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {

        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        /**
         *  6条数据 每页显示3行  需要2页
         *      6/3=2
         *  6条数据 每页显示4行  需要2页
         *      6/2+1 = 1 + 1 = 2
         *
         *       if (totalCount%pageSize==0){
         *             totalPage = totalPage/pageSize;
         *         }else {
         *             totalPage = totalPage/pageSize+1;
         *         }
         */
        //或者直接通过想想取整来替换循环
        totalPage = (int) Math.ceil((double) totalCount / pageSize);
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        //若对totalCount进行改动，重新计算总页数
        totalPage = (int) Math.ceil((double) totalCount / pageSize);
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "pageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
