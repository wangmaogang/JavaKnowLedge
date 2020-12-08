package just.met.springboot.状态机与实际项目.service;

import just.met.springboot.idemp.eneity.R;
import just.met.springboot.状态机与实际项目.define.AgreementStatus;
import just.met.springboot.状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.状态机与实际项目.eneity.Agreement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class MessageSendServiceImpl implements MessageSendService{

    @Resource
    private StateMachine<AgreementStatus, AgreementStatusChangeEvent> agreementStateMachine;

    @Resource
    private StateMachinePersister<AgreementStatus, AgreementStatusChangeEvent, Agreement> agreementPersister;

    @Override
    public R send(AgreementStatusChangeEvent event, Agreement agreement) {
        Message<AgreementStatusChangeEvent> message = MessageBuilder.withPayload(event).setHeader("agreement", agreement).build();
        String result = "";
        if (!sendMessage(message, agreement)) {
            result = "######" + event + "失败, 状态异常 id=" + agreement.getId() + " threadName=" + Thread.currentThread().getName();
            log.info(result);
            return R.error(result);
        } else {
            result = "######" + event + "成功 id=" + agreement.getId() + " threadName=" + Thread.currentThread().getName();
            log.info(result);
            return R.ok(result);
        }

    }

    @Override
    public boolean sendMessage(Message<AgreementStatusChangeEvent> message, Agreement agreement) {
        agreementStateMachine.start();
        return agreementStateMachine.sendEvent(message);
    }
}
