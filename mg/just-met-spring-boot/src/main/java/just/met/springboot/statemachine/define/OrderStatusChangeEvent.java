package just.met.springboot.statemachine.define;

/**
 * 订单状态改变事件
 */
public enum OrderStatusChangeEvent {
    //支付
    PAY,
    //发货
    DELIVER,
    //确认收货
    RECEIVE
}
