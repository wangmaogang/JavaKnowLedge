package just.met.springboot.Spring状态机与实际项目.define;

/**
 * 委托协议状态改变事件
 * @author wangmaogang
 */
public enum AgreementStatusChangeEvent {
    //保存
    SAVE,
    //提交
    SUBMIT,
    //驳回
    REFUSE,
    //确认
    CONFIRM,
    //完成
    COMPLETE
}
