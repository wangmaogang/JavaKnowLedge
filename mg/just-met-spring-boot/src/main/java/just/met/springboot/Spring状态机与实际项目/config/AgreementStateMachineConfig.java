package just.met.springboot.Spring状态机与实际项目.config;

import just.met.springboot.Spring状态机与实际项目.define.AgreementStatus;
import just.met.springboot.Spring状态机与实际项目.define.AgreementStatusChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * 委托协议状态机配置
 *
 * @author wangmaogang
 */
@Configuration
@EnableStateMachine(name = "agreementStateMachine")
@Slf4j
public class AgreementStateMachineConfig extends EnumStateMachineConfigurerAdapter<AgreementStatus, AgreementStatusChangeEvent> {

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
                .withExternal()
                .source(AgreementStatus.INIT)
                .target(AgreementStatus.IS_SAVED)
                .event(AgreementStatusChangeEvent.SAVE)

                .and()
                .withExternal()
                .source(AgreementStatus.IS_SAVED)
                .target(AgreementStatus.IS_SUBMITTED)
                .event(AgreementStatusChangeEvent.SUBMIT)

                .and()
                .withExternal()
                .source(AgreementStatus.IS_SUBMITTED)
                .target(AgreementStatus.IS_CONFIRMED)
                .event(AgreementStatusChangeEvent.CONFIRM)

                .and()
                .withExternal()
                .source(AgreementStatus.IS_SUBMITTED)
                .target(AgreementStatus.IS_REFUSED)
                .event(AgreementStatusChangeEvent.REFUSE)

                .and()
                .withExternal()
                .source(AgreementStatus.IS_CONFIRMED)
                .target(AgreementStatus.IS_COMPLETED)
                .event(AgreementStatusChangeEvent.COMPLETE);
    }

}
