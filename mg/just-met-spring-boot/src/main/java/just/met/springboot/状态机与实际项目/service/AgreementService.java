package just.met.springboot.状态机与实际项目.service;

import just.met.springboot.idemp.eneity.R;
import just.met.springboot.状态机与实际项目.eneity.Agreement;

public interface AgreementService {

    Agreement init();

    R save(String id);

    R submit(String id);

    R refuse(String id);

    R confirm(String id) ;

    R complete(String id) ;
}
