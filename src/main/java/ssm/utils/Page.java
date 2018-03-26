package ssm.utils;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/10/10
 */
public class Page {
    private int pageCount;//页数
    private int pageSize;//
    private int currentPage;//当前页
    private int totle;// 条数

    public int getTotle() {
        return totle;
    }

    public void setTotle(int totle) {
        this.totle = totle;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
