package just.met.springboot.状态机与实际项目.service;

import just.met.springboot.idemp.eneity.R;
import just.met.springboot.状态机与实际项目.define.AgreementStatus;
import just.met.springboot.状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.状态机与实际项目.eneity.Agreement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("agreementService")
@Slf4j
public class AgreementServiceImpl implements AgreementService {

    @Resource
    MessageSendService messageSendService;

    /**
     * 委托协议暂存map
     */
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
    public R save(String id) {
        Agreement agreement = agreementMap.get(id);
        return messageSendService.send(AgreementStatusChangeEvent.SAVE, agreement);
    }

    @Override
    public R submit(String id) {
        Agreement agreement = agreementMap.get(id);
        return messageSendService.send(AgreementStatusChangeEvent.SUBMIT, agreement);
    }

    @Override
    public R refuse(String id) {
        Agreement agreement = agreementMap.get(id);
        return messageSendService.send(AgreementStatusChangeEvent.REFUSE, agreement);
    }

    @Override
    public R confirm(String id) {
        Agreement agreement = agreementMap.get(id);
        return messageSendService.send(AgreementStatusChangeEvent.CONFIRM, agreement);
    }

    @Override
    public R complete(String id) {
        Agreement agreement = agreementMap.get(id);
        return messageSendService.send(AgreementStatusChangeEvent.COMPLETE, agreement);
    }
}