package just.met.springboot.idemp.eneity;

/**
 * 请求详情实体类
 * @author wangmaogang
 */
public class RequestInfo {

    private String operateId;

    private String method;

    private String businessId;

    public RequestInfo(String operateId,String method,String businessId){
        this.operateId = operateId;
        this.method = method;
        this.businessId = businessId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String bId) {
        this.businessId = bId;
    }

    public String getOperateId() {
        return operateId;
    }

    public void setOperateId(String operateId) {
        this.operateId = operateId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "businessId='" + businessId + '\'' +
                ", operateId='" + operateId + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
