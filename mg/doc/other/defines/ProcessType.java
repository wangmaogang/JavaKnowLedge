package just.met.javabase.common.defines;

/**
 * 流程枚举类
 * @author wangmaogang
 */
public enum ProcessType {

    ALLOCATION("100","调拨申请流程"),
    DELAY("200","延期检定校准流程"),
    LOSS_ACCIDENT("300","丢失事故流程"),
    SEALING_UNSEALING("400","封存启封流程"),
    ELSE_WHERE("500","异地计量审批流程"),
    SCRAP("600","报废申请流程"),
    C_CATEGORY("700","C类申请流程"),
    UNQUALIFIED("800","不合格追溯流程");

    ProcessType(String type, String des) {
        this.type = type;
        this.des = des;
    }

    private String type;
    private String des;

    public String getDes() {
        return des;
    }
    public String getType() {
        return type;
    }
}
