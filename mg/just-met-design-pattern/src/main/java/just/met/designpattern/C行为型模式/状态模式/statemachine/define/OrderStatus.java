package just.met.designpattern.C行为型模式.状态模式.statemachine.define;

/**
 * 订单状态
 * @author wangmaogang
 */
public enum OrderStatus {
    //待保存
    WAIT_SAVE,
    //待提交
    WAIT_SUBMIT,
    //待确认
    WAIT_CONFIRM,
    //待驳回
    WAIT_REFUSE,
}
