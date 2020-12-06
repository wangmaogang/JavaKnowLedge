package just.met.springboot.状态机与实际项目.eneity;
import just.met.springboot.状态机与实际项目.define.AgreementStatus;

/**
 * 委托协议
 * @author wangmaogang
 */
public class Agreement {
    private String id;
    private AgreementStatus status;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AgreementStatus getStatus() {
        return status;
    }

    public void setStatus(AgreementStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
