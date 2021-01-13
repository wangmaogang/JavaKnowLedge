package just.met.springboot.idemp.eneity;


import java.io.Serializable;
import java.util.List;

public class PageUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    private long total;
    private List<?> rows;
    private long currPage;

    public PageUtils(List<?> list, long total) {
        this.rows = list;
        this.total = total;
    }

    public PageUtils(List<?> list, long total, long currPage) {
        this.rows = list;
        this.total = total;
        this.currPage = currPage;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return this.rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getCurrPage() {
        return this.currPage;
    }

    public void setCurrPage(long currPage) {
        this.currPage = currPage;
    }
}

