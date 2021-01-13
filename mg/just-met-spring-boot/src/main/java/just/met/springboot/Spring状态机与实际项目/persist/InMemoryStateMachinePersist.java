package just.met.springboot.Spring状态机与实际项目.persist;

import just.met.springboot.Spring状态机与实际项目.define.AgreementStatus;
import just.met.springboot.Spring状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.Spring状态机与实际项目.eneity.Agreement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 持久化到内存
 */
@Component
@Slf4j
public class InMemoryStateMachinePersist implements StateMachinePersist<AgreementStatus, AgreementStatusChangeEvent, Agreement> {

    private final HashMap<String, StateMachineContext<AgreementStatus,AgreementStatusChangeEvent>> storage = new HashMap<>();

    @Override
    public void write(StateMachineContext<AgreementStatus, AgreementStatusChangeEvent> context, Agreement contextObj) throws Exception {
        storage.put(contextObj.getId(), context);
    }

    @Override
    public StateMachineContext<AgreementStatus, AgreementStatusChangeEvent> read(Agreement contextObj) throws Exception {
        return storage.get(contextObj.getId());
    }
}

