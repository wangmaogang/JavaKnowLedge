package just.met.javabase.common.defines;

/**
 * 流程统一错误提示类
 * @author wangmaogang
 */
public class ProcessResponse {

    /**
     * 流程通用错误返回
     */
    public interface COMMON_ERROR{
        String ERROR_1 = "流程ERROR-001:该设备正在流程审批中，请耐心等待！";
    }

    /**
     * 调拨申请流程错误返回
     */
    public interface ALLOCATION_ERROR{
        String ERROR_1 = "流程ERROR-101:该设备已封存，不可调拨！";
    }

    /**
     * 延期检定校准流程错误返回
     */
    public interface DELAY_ERROR{
        String ERROR_1 = "流程ERROR-201:该设备未过有效期，无需发起延期！";
    }

    /**
     * 丢失事故流程错误返回
     */
    public interface LOSS_ACCIDENT_ERROR{
        String ERROR_1 = "流程ERROR-301:该设备已丢失或事故，无需发起此流程";
    }

    /**
     * 封存启封流程错误返回
     */
    public interface SEALING_UNSEALING_ERROR{
        String ERROR_1 = "流程ERROR-401:该设备不在有效期内,不允许封存！";
        String ERROR_2 = "流程ERROR-402:该设备已经是启用状态，无需发起此流程！";
        String ERROR_3 = "流程ERROR-403:该设备已经是封存状态，无需发起此流程！";

    }

    /**
     * 异地计量审批流程错误返回
     */
    public interface ELSE_WHERE_ERROR{
        String ERROR_1 = "流程ERROR-501:未知错误";
    }

    /**
     * 报废申请流程错误返回
     */
    public interface SCRAP_ERROR{
        String ERROR_1 = "流程ERROR-601:该设备已报废，无需发起此流程!";
    }

    /**
     * C类申请流程错误返回
     */
    public interface C_CATEGORY_ERROR{
        String ERROR_1 = "流程ERROR-701:该设备是C类，无需发起此流程!";
    }

    /**
     * 不合格追溯流程错误返回
     */
    public interface UNQUALIFIED_ERROR{
        String ERROR_1 = "流程ERROR-801:未知错误";
    }

}
