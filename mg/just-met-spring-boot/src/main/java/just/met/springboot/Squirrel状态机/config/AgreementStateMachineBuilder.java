package just.met.springboot.Squirrel状态机.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

@Configuration
public class AgreementStateMachineBuilder{

    @Bean
    public UntypedStateMachineBuilder build() {
        return StateMachineBuilderFactory.create(AgreementStateMachine.class);
    }

}
