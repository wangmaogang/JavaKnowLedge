package just.met.springboot.statemachine.define;

/**
 * 订单状态
 * @author wangmaogang
 */
public enum OrderStatus {
    //待支付
    WAIT_PAYMENT,
    //待发货
    WAIT_DELIVER,
    //待收货
    WAIT_RECEIVE,
    //完成
    FINISH
}
