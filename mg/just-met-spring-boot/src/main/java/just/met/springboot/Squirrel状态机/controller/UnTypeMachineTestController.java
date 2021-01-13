package just.met.springboot.Squirrel状态机.controller;

import just.met.springboot.Spring状态机与实际项目.define.AgreementStatus;
import just.met.springboot.Spring状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.Squirrel状态机.entity.AgreementInfo;
import just.met.springboot.idemp.eneity.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("agreement/machine")
public class UnTypeMachineTestController {

    @Resource
    UntypedStateMachineBuilder untypedStateMachineBuilder;

    /**
     * 测试地址：http://localhost:8888/api/agreement/machine/save
     */
    @GetMapping("save")
    public R save() {
        AgreementInfo agreementInfo = new AgreementInfo();
        agreementInfo.setStatus(AgreementStatus.INIT.toString());
        agreementInfo.setName("save###" + UUID.randomUUID().toString());
        UntypedStateMachine stateMachine = untypedStateMachineBuilder.newStateMachine(AgreementStatus.INIT);
        stateMachine.fire(AgreementStatusChangeEvent.SAVE,agreementInfo);
        return R.ok().put("data",agreementInfo.getId());
    }

    @GetMapping("test2")
    public void test2() {
        AgreementInfo agreementInfo = new AgreementInfo();
        agreementInfo.setStatus(AgreementStatus.INIT.toString());
        agreementInfo.setName("save###" + UUID.randomUUID().toString());
        UntypedStateMachine stateMachine = untypedStateMachineBuilder.newStateMachine(AgreementStatus.INIT);
        stateMachine.fire(AgreementStatusChangeEvent.SAVE,agreementInfo);

        stateMachine.fire(AgreementStatusChangeEvent.SAVE,agreementInfo);
        stateMachine.fire(AgreementStatusChangeEvent.SUBMIT,agreementInfo);
        stateMachine.fire(AgreementStatusChangeEvent.CONFIRM,agreementInfo);
        stateMachine.fire(AgreementStatusChangeEvent.COMPLETE,agreementInfo);
    }

}
