package just.met.springboot.Spring状态机与实际项目.define;

/**
 * 订单状态
 * @author wangmaogang
 */
public enum AgreementStatus {
    //初始化状态
    INIT,
    //保存
    IS_SAVED,
    //提交
    IS_SUBMITTED,
    //确认
    IS_CONFIRMED,
    //驳回
    IS_REFUSED,
    //完成
    IS_COMPLETED
}
