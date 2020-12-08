package just.met.springboot.状态机与实际项目;

import just.met.springboot.idemp.eneity.R;
import just.met.springboot.状态机与实际项目.define.AgreementStatus;
import just.met.springboot.状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.状态机与实际项目.eneity.Agreement;
import just.met.springboot.状态机与实际项目.service.AgreementService;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/machine")
public class MachineTestController {

    @Resource
    AgreementService agreementService;

    /**
     * 测试地址：http://localhost:8888/api/api/machine/test1
     */
    @GetMapping("test1")
    public R test1() {
        Agreement agreement = agreementService.init();
        agreementService.save(agreement.getId());
        agreementService.submit(agreement.getId());
        agreementService.submit(agreement.getId());
        agreementService.submit(agreement.getId());
        agreementService.confirm(agreement.getId());
        agreementService.complete(agreement.getId());
        return R.ok().put("data",agreement);
    }

}
