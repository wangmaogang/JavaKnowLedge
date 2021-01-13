package just.met.springboot.feign.controller.test;

import just.met.springboot.JustMetSpringBootApplication;
import just.met.springboot.Spring状态机与实际项目.eneity.Agreement;
import just.met.springboot.Spring状态机与实际项目.service.AgreementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@SpringBootTest(classes = JustMetSpringBootApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MachineTest {

    @Resource
    AgreementService agreementService;

    @Test
    public void machineTest() {
        Agreement agreement = agreementService.init();
        agreementService.save(agreement.getId());
        agreementService.submit(agreement.getId());
        agreementService.confirm(agreement.getId());
        agreementService.complete(agreement.getId());
        System.out.println(agreement.getStatus());
    }
}