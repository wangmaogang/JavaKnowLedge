package just.met.springboot.statemachine.listener;

import just.met.springboot.statemachine.define.OrderStatus;
import just.met.springboot.statemachine.define.OrderStatusChangeEvent;
import just.met.springboot.statemachine.eneity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

/**
 * 订单状态监听器
 * @author wangmaogang
 */
@Component
@WithStateMachine(name = "OrderStateMachine")
@Slf4j
public class OrderStateMachineListener {

    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public boolean payTransition(Message<OrderStatusChangeEvent> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.WAIT_DELIVER);
        log.info("OrderStateMachineListener.payTransition | headers=" + message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public boolean deliverTransition(Message<OrderStatusChangeEvent> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.WAIT_RECEIVE);
        log.info("OrderStateMachineListener.deliverTransition | headers=" + message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public boolean receiveTransition(Message<OrderStatusChangeEvent> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.FINISH);
        log.info("OrderStateMachineListener.receiveTransition | headers=" + message.getHeaders().toString());
        return true;
    }

}
