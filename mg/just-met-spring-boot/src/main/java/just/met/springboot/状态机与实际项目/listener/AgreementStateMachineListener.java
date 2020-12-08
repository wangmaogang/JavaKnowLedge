package just.met.springboot.状态机与实际项目.listener;

import just.met.springboot.状态机与实际项目.define.AgreementStatus;
import just.met.springboot.状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.状态机与实际项目.eneity.Agreement;
import just.met.springboot.状态机与实际项目.service.AgreementService;
import just.met.springboot.状态机与实际项目.service.AgreementServiceUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 委托协议状态处理器
 * @author wangmaogang
 */
@Component
@WithStateMachine(name = "agreementStateMachine")
@Slf4j
public class AgreementStateMachineListener {

    @Resource
    AgreementServiceUpdate agreementServiceUpdate;

    /**
     * 【事件处理器方法】初始化到保存
     * @param message AgreementStatusChangeEvent
     * @return boolean
     */
    @OnTransition(source = "INIT", target = "IS_SAVED")
    public boolean saveTransition(Message<AgreementStatusChangeEvent> message){
        Agreement agreement = (Agreement) message.getHeaders().get("agreement");
        Objects.requireNonNull(agreement).setStatus(AgreementStatus.IS_SAVED);
        agreementServiceUpdate.save(agreement);
        log.info("AgreementStateMachineListener.saveTransition | agreement.id = " + agreement.getId());
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
        agreementServiceUpdate.submit(agreement);
        log.info("AgreementStateMachineListener.submitTransition | agreement.id = " + agreement.getId());
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
        agreementServiceUpdate.confirm(agreement);
        log.info("AgreementStateMachineListener.confirmTransition | agreement.id = " + agreement.getId());
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
        agreementServiceUpdate.refuse(agreement);
        log.info("AgreementStateMachineListener.refuseTransition | agreement.id = " + agreement.getId());
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
        agreementServiceUpdate.complete(agreement);
        log.info("AgreementStateMachineListener.completeTransition | agreement.id = " + agreement.getId());
        return true;
    }

}
