package just.met.springboot.idemp.eneity;

import java.io.Serializable;

/**
 * @author wangmaogang
 */
public class TestEntity implements Serializable {
    private String orderId;
    private String status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
