package just.met.springboot.statemachine.eneity;

import just.met.springboot.statemachine.define.OrderStatus;
import lombok.Data;

/**
 * 订单
 * @author wangmaogang
 */
@Data
public class Order {
    private int id;
    private OrderStatus status;
    private String name;
}
