package just.met.designpattern.C行为型模式.状态模式.statemachine.eneity;
import just.met.designpattern.C行为型模式.状态模式.statemachine.define.OrderStatus;

/**
 * 订单
 * @author wangmaogang
 */
public class Order {
    private int id;
    private OrderStatus status;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
