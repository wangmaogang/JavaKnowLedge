package just.met.javabase.common.process.service.impl;

import just.met.javabase.common.process.service.IProcessApproval;

/**
 * 不合格追溯流程
 * @author wangmaogang
 */
public class UnqualifiedProcessImpl implements IProcessApproval {
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
