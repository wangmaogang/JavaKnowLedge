package just.met.springboot.idemp.service.impl;

import just.met.springboot.idemp.eneity.RequestInfo;
import just.met.springboot.idemp.service.IdGenerator;

/**
 * 固定格式幂等号生成
 *
 * @author wangmaogang
 */
public class FixedIdempotenceIdGenerator implements IdGenerator {

    private RequestInfo requestInfo;

    private final String splitFlag = ":";

    public FixedIdempotenceIdGenerator(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    /**
     * 幂等号生成,固定规则为：操作人id + 请求的实际方法 + 此次请求的业务主键
     *
     * @return 返回幂等号
     */
    @Override
    public String generateId() {
        return requestInfo.getOperateId() + splitFlag + requestInfo.getMethod() + splitFlag + requestInfo.getBusinessId();
    }
}
