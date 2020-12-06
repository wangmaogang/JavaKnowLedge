package just.met.springboot.状态机与实际项目.service;

import just.met.springboot.状态机与实际项目.define.AgreementStatus;
import just.met.springboot.状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.状态机与实际项目.define.Contacts;
import just.met.springboot.状态机与实际项目.eneity.Agreement;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("agreementService")
public class AgreementServiceImpl implements AgreementService {

    @Resource
    private StateMachine<AgreementStatus, AgreementStatusChangeEvent> agreementStateMachine;
    @Resource
    private StateMachinePersister<AgreementStatus, AgreementStatusChangeEvent, Agreement> agreementPersister;

    private final Map<String, Agreement> agreementMap = new HashMap<>();


    @Override
    public Agreement init() {
        Agreement agreement = new Agreement();
        agreement.setId(UUID.randomUUID().toString());
        agreement.setStatus(AgreementStatus.INIT);
        agreementMap.put(agreement.getId(), agreement);
        return agreement;
    }

    @Override
    public Agreement save(String id) {
        Agreement agreement = agreementMap.get(id);
        send(AgreementStatusChangeEvent.SAVE, agreement);
        return agreementMap.get(id);
    }

    @Override
    public Agreement submit(String id) {
        Agreement agreement = agreementMap.get(id);
        send(AgreementStatusChangeEvent.SUBMIT, agreement);
        return agreementMap.get(id);
    }

    @Override
    public Agreement refuse(String id) {
        Agreement agreement = agreementMap.get(id);
        send(AgreementStatusChangeEvent.REFUSE, agreement);
        return agreementMap.get(id);
    }

    @Override
    public Agreement confirm(String id) {
        Agreement agreement = agreementMap.get(id);
        send(AgreementStatusChangeEvent.CONFIRM, agreement);
        return agreementMap.get(id);
    }

    @Override
    public Agreement complete(String id) {
        Agreement agreement = agreementMap.get(id);
        send(AgreementStatusChangeEvent.COMPLETE, agreement);
        return agreementMap.get(id);
    }

    /**
     * 发送委托协议状态转换事件
     *
     * @param message
     * @param agreement
     * @return
     */
    private boolean sendEvent(Message<AgreementStatusChangeEvent> message, Agreement agreement) {
        boolean result = agreementStateMachine.sendEvent(message);
        if(result){
            //持久化
            try {
                agreementPersister.persist(agreementStateMachine, agreement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送
     *
     * @param event
     * @param agreement
     * @return
     */
    private boolean send(AgreementStatusChangeEvent event, Agreement agreement) {
        Message<AgreementStatusChangeEvent> message = MessageBuilder.withPayload(event).setHeader("agreement", agreement).build();
        if (!sendEvent(message, agreement)) {
            System.out.println("######" + event + "失败, 状态异常 id=" + agreement.getId() + " threadName=" + Thread.currentThread().getName());
            return false;
        } else {
            System.out.println("######" + event + "成功 id=" + agreement.getId() + " threadName=" + Thread.currentThread().getName());
            return true;

        }
    }
}