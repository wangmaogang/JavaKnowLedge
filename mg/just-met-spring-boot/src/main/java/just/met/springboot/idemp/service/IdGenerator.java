package just.met.springboot.idemp.service;

/**
 * 幂等号生成接口
 * @author wangmaogang
 */
public interface IdGenerator {

    /**
     * 幂等号生成
     * @return 返回幂等号
     */
    String generateId();
}
