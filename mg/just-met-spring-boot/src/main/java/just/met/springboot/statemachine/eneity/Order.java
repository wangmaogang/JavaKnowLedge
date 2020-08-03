package just.met.springboot.statemachine.eneity;

import just.met.springboot.statemachine.define.OrderStatus;
import lombok.Data;

@Data
public class Order {
    private int id;
    private OrderStatus status;
    private String name;
}
