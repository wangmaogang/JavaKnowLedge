package just.met.springboot.Squirrel状态机.config;

import just.met.springboot.Spring状态机与实际项目.define.AgreementStatus;
import just.met.springboot.Spring状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.Squirrel状态机.entity.AgreementInfo;
import just.met.springboot.Squirrel状态机.service.AgreementInfoService;
import just.met.springboot.策略及门面模式结合Spring.utils.SpringBeanFactoryUtils;
import lombok.extern.slf4j.Slf4j;
import org.squirrelframework.foundation.fsm.annotation.*;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

@Slf4j
@States({
        // @State(name="IS_SAVED", entryCallMethod="entrySave", exitCallMethod="exitSave"),
        // @State(name="IS_SUBMITTED", entryCallMethod="entrySubmit", exitCallMethod="exitSubmit"),
        // @State(name="IS_CONFIRMED", entryCallMethod="entryConfirm", exitCallMethod="exitConfirm")
})
@Transitions({
        @Transit(from="INIT", to="IS_SAVED", on="SAVE", callMethod="saveTransit"),
        @Transit(from="IS_SAVED", to="IS_SUBMITTED", on="SUBMIT", callMethod="submitTransit"),
        @Transit(from="IS_SUBMITTED", to="IS_CONFIRMED", on="CONFIRM", callMethod="confirmTransit"),
        @Transit(from="IS_SUBMITTED", to="IS_REFUSED", on="REFUSE", callMethod="refuseTransit"),
        @Transit(from="IS_CONFIRMED", to="IS_COMPLETED", on="COMPLETE", callMethod="completeTransit"),
})
@StateMachineParameters(stateType= AgreementStatus.class, eventType= AgreementStatusChangeEvent.class, contextType= AgreementInfo.class)
public class AgreementStateMachine extends AbstractUntypedStateMachine {

    AgreementInfoService agreementInfoService;

    //region 【初始化 -> 保存】
    @AsyncExecute
    protected void saveTransit(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###saveTransit");
        context.setStatus(to.toString());
        agreementInfoService = SpringBeanFactoryUtils.getBean(AgreementInfoService.class);
        agreementInfoService.insert(context);
        log.info("###saveTransit,context.id:"+context.getId());
    }
    protected void entrySave(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###entrySave");
    }
    //endregion

    //region 【保存 -> 提交】
    // 1、退出save：exitSave;
    // 2、执行转换：submitTransit;
    // 3、进入submit:entrySubmit

    protected void exitSave(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###exitSave");
    }

    @AsyncExecute
    protected void submitTransit(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###submitTransit,context.id:"+context.getId());
        context.setStatus(to.toString());
        agreementInfoService = SpringBeanFactoryUtils.getBean(AgreementInfoService.class);
        agreementInfoService.update(context);
    }

    protected void entrySubmit(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###entrySubmit");
    }
    //endregion

    //region 【提交 -> 确认】
    protected void exitSubmit(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###exitSubmit");
    }
    @AsyncExecute
    protected void confirmTransit(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###confirmTransit,context.id:"+context.getId());
        context.setStatus(to.toString());
        agreementInfoService = SpringBeanFactoryUtils.getBean(AgreementInfoService.class);
        agreementInfoService.update(context);
    }
    protected void entryConfirm(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###entryConfirm");
    }
    //endregion

    //region 【提交 -> 拒绝】
    @AsyncExecute
    protected void refuseTransit(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###refuseTransit,context.id:"+context.getId());
        context.setStatus(to.toString());
        agreementInfoService = SpringBeanFactoryUtils.getBean(AgreementInfoService.class);
        agreementInfoService.update(context);
    }
    //endregion

    //region 【确认 -> 完成】

    protected void exitConfirm(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###exitConfirm");
    }
    @AsyncExecute
    protected void completeTransit(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###completeTransit,context.id:"+context.getId());
        context.setStatus(to.toString());
        agreementInfoService = SpringBeanFactoryUtils.getBean(AgreementInfoService.class);
        agreementInfoService.update(context);
    }

    protected void exitComplete(AgreementStatus from, AgreementStatus to, AgreementStatusChangeEvent event, AgreementInfo context) {
        log.info("###exitComplete");
    }
    //endregion

    @Override
    protected void afterTransitionCausedException(Object fromState, Object toState, Object event, Object context) {
        Throwable targetException = getLastException().getTargetException();
        log.info("###afterTransitionCausedException:"+targetException.getMessage());
    }
}
