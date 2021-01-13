package just.met.springboot.Spring状态机与实际项目.config;


import just.met.springboot.Spring状态机与实际项目.define.AgreementStatus;
import just.met.springboot.Spring状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.Spring状态机与实际项目.eneity.Agreement;
import just.met.springboot.Spring状态机与实际项目.persist.InMemoryStateMachinePersist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

import javax.annotation.Resource;


/**
 *持久化配置，实际使用中，可以配合redis等，进行持久化操作
 */
@Configuration
public class PersistConfig {

    @Resource
    private InMemoryStateMachinePersist inMemoryStateMachinePersist;

    @Bean(name = "agreementPersister")
    public StateMachinePersister<AgreementStatus, AgreementStatusChangeEvent, Agreement> getPersister() {
        return new DefaultStateMachinePersister<>(inMemoryStateMachinePersist);
    }
}
