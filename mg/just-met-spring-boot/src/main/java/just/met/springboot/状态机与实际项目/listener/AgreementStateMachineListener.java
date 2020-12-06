package just.met.springboot.状态机与实际项目.listener;

import just.met.springboot.状态机与实际项目.config.AgreementStateMachineConfig;
import just.met.springboot.状态机与实际项目.define.AgreementStatus;
import just.met.springboot.状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.状态机与实际项目.define.Contacts;
import just.met.springboot.状态机与实际项目.eneity.Agreement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 委托协议状态处理器
 * @author wangmaogang
 */
@Component
@WithStateMachine(name = "agreementStateMachine")
@Slf4j
public class AgreementStateMachineListener {

    /**
     * 【事件处理器方法】初始化到保存
     * @param message AgreementStatusChangeEvent
     * @return boolean
     */
    @OnTransition(source = "INIT", target = "IS_SAVED")
    public boolean saveTransition(Message<AgreementStatusChangeEvent> message){
        Agreement agreement = (Agreement) message.getHeaders().get("agreement");
        Objects.requireNonNull(agreement).setStatus(AgreementStatus.IS_SAVED);
        log.info("AgreementStateMachineListener.saveTransition | headers=" + message.getHeaders().toString());
        return true;
    }

    /**
     * 【事件处理器方法】保存到提交
     * @param message AgreementStatusChangeEvent
     * @return boolean
     */
    @OnTransition(source = "IS_SAVED", target = "IS_SUBMITTED")
    public boolean submitTransition(Message<AgreementStatusChangeEvent> message){
        Agreement agreement = (Agreement) message.getHeaders().get("agreement");
        Objects.requireNonNull(agreement).setStatus(AgreementStatus.IS_SUBMITTED);
        log.info("AgreementStateMachineListener.submitTransition | headers=" + message.getHeaders().toString());
        return true;
    }

    /**
     * 【事件处理器方法】提交到确认
     * @param message AgreementStatusChangeEvent
     * @return boolean
     */
    @OnTransition(source = "IS_SUBMITTED", target = "IS_CONFIRMED")
    public boolean confirmTransition(Message<AgreementStatusChangeEvent> message){
        Agreement agreement = (Agreement) message.getHeaders().get("agreement");
        Objects.requireNonNull(agreement).setStatus(AgreementStatus.IS_CONFIRMED);
        log.info("AgreementStateMachineListener.confirmTransition | headers=" + message.getHeaders().toString());
        return true;
    }

    /**
     * 【事件处理器方法】提交到拒绝
     * @param message AgreementStatusChangeEvent
     * @return boolean
     */
    @OnTransition(source = "IS_SUBMITTED", target = "IS_REFUSED")
    public boolean refuseTransition(Message<AgreementStatusChangeEvent> message){
        Agreement agreement = (Agreement) message.getHeaders().get("agreement");
        Objects.requireNonNull(agreement).setStatus(AgreementStatus.IS_REFUSED);
        log.info("AgreementStateMachineListener.refuseTransition | headers=" + message.getHeaders().toString());
        return true;
    }

    /**
     * 【事件处理器方法】确认到完成
     * @param message AgreementStatusChangeEvent
     * @return boolean
     */
    @OnTransition(source = "IS_CONFIRMED", target = "IS_COMPLETED")
    public boolean completeTransition(Message<AgreementStatusChangeEvent> message){
        Agreement agreement = (Agreement) message.getHeaders().get("agreement");
        Objects.requireNonNull(agreement).setStatus(AgreementStatus.IS_COMPLETED);
        log.info("AgreementStateMachineListener.completeTransition | headers=" + message.getHeaders().toString());
        return true;
    }

}
