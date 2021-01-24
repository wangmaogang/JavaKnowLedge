package just.met.mybatis.plus.test3;

import java.util.ArrayList;
import java.util.List;

public interface IAgreementOperate {
    String agreementId = null;

   boolean confirm();

    default String getAgreementId() {
        List<String> list = new ArrayList<String>();
        return agreementId;
    }

}
