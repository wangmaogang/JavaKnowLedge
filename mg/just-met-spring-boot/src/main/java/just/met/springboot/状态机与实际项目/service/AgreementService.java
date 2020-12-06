package just.met.springboot.状态机与实际项目.service;

import just.met.springboot.状态机与实际项目.eneity.Agreement;

public interface AgreementService {

    Agreement init();

    Agreement save(String id);

    Agreement submit(String id);

    Agreement refuse(String id);

    Agreement confirm(String id) ;

    Agreement complete(String id) ;
}
