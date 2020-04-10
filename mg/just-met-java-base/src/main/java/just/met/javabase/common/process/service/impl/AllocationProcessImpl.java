package just.met.javabase.common.process.service.impl;

import just.met.javabase.common.process.service.IProcessApproval;

/**
 * 调拨申请流程实现类
 * @author wangmaogang
 */
public class AllocationProcessImpl implements IProcessApproval {
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
