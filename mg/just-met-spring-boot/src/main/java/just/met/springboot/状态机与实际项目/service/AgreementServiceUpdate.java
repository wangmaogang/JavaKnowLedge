package just.met.springboot.状态机与实际项目.service;

import just.met.springboot.idemp.eneity.R;
import just.met.springboot.状态机与实际项目.eneity.Agreement;

public interface AgreementServiceUpdate {

    R save(Agreement agreement);

    R submit(Agreement agreement);

    R refuse(Agreement agreement);

    R confirm(Agreement agreement) ;

    R complete(Agreement agreement) ;
}
