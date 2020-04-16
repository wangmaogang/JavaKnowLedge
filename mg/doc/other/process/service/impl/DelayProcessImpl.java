package just.met.javabase.common.process.service.impl;

import just.met.javabase.common.process.service.IProcessApproval;

/**
 * 延期检定校准流程实现类
 * @author wangmaogang
 */
public class DelayProcessImpl implements IProcessApproval {
    @Override
    public boolean checkStatus() {
        return false;
    }

    @Override
    public boolean execute(String processType, String role) {
        return false;
    }

    @Override
    public String getType() {
        return null;
    }
}
