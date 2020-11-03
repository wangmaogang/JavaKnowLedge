package just.met.designpattern.C行为型模式.状态模式.statemachine.define;

/**
 * 订单状态改变事件
 * @author wangmaogang
 */
public enum OrderStatusChangeEvent {
    //保存
    SAVE,
    //提交
    SUBMIT,
    //驳回
    REFUSE,
    //确认
    CONFIRM
}
