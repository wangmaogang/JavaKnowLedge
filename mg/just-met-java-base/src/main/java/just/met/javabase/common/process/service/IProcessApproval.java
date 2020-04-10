package just.met.javabase.common.process.service;

/**
 * 流程审批接口
 * @author wangmaogang
 */
public interface IProcessApproval {

    /**
     * 流程开始前状态检测
     * @return
     */
    boolean checkStatus();

    /**
     * 流程审批执行方法：每个流程，每个角色的执行都是不同的
     * @param processType
     * @param role
     * @return
     */
    boolean execute(String processType,String role);

    /**
     * 流程审批类型
     * @return
     */
    String getType();
}
