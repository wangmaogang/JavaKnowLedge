package just.met.springboot.状态机与实际项目.config;

import just.met.springboot.状态机与实际项目.define.AgreementStatus;
import just.met.springboot.状态机与实际项目.define.AgreementStatusChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import java.util.EnumSet;
import java.util.Optional;

/**
 * 委托协议状态机配置
 *
 * @author wangmaogang
 */
@Configuration
@EnableStateMachine(name = "agreementStateMachine")
@Slf4j
public class AgreementStateMachineConfig extends EnumStateMachineConfigurerAdapter<AgreementStatus, AgreementStatusChangeEvent> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<AgreementStatus, AgreementStatusChangeEvent> config) throws Exception {
        config.withConfiguration()
                .listener(listener())
                .autoStartup(true);
    }

    private StateMachineListener<AgreementStatus, AgreementStatusChangeEvent> listener() {

        return new StateMachineListenerAdapter<AgreementStatus, AgreementStatusChangeEvent>() {
            @Override
            public void eventNotAccepted(Message<AgreementStatusChangeEvent> event) {
                log.error("Not accepted event: {}", event);
            }

            @Override
            public void transition(Transition<AgreementStatus, AgreementStatusChangeEvent> transition) {
                log.warn("MOVE from: {}, to: {}",
                        ofNullableState(transition.getSource()),
                        ofNullableState(transition.getTarget()));
            }

            private Object ofNullableState(State s) {
                return Optional.ofNullable(s)
                        .map(State::getId)
                        .orElse(null);
            }
        };
    }

    /**
     * 配置状态
     *
     * @param states 状态
     * @throws Exception 抛异常
     */
    @Override
    public void configure(StateMachineStateConfigurer<AgreementStatus, AgreementStatusChangeEvent> states) throws Exception {
        states.withStates()
                .initial(AgreementStatus.INIT)
                .states(EnumSet.allOf(AgreementStatus.class));
    }

    /**
     * 配置状态转换事件关系
     *
     * @param transitions 转换关系
     * @throws Exception 抛异常
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<AgreementStatus, AgreementStatusChangeEvent> transitions) throws Exception {
        transitions
                .withExternal().source(AgreementStatus.INIT).target(AgreementStatus.IS_SAVED).event(AgreementStatusChangeEvent.SAVE)
                .and()
                .withExternal().source(AgreementStatus.IS_SAVED).target(AgreementStatus.IS_SUBMITTED).event(AgreementStatusChangeEvent.SUBMIT)
                .and()
                .withExternal().source(AgreementStatus.IS_SUBMITTED).target(AgreementStatus.IS_CONFIRMED).event(AgreementStatusChangeEvent.CONFIRM)
                .and()
                .withExternal().source(AgreementStatus.IS_SUBMITTED).target(AgreementStatus.IS_REFUSED).event(AgreementStatusChangeEvent.REFUSE)
                .and()
                .withExternal().source(AgreementStatus.IS_CONFIRMED).target(AgreementStatus.IS_COMPLETED).event(AgreementStatusChangeEvent.COMPLETE);
    }

}
