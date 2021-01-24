package just.met.mybatis.plus.test3;

public class FirstCheckAgreementOperate implements IAgreementOperate{

    @Override
    public boolean confirm() {
        return false;
    }

    @Override
    public String getAgreementId() {
        return agreementId;
    }
}
