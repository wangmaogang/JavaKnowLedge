package just.met.springboot.策略及门面模式结合Spring.singleton;

/**
 * 策略执行单例类
 * @author wangmaogang
 */

public enum StrategyExecuteSingletonEnum {
    //创建一个枚举对象，该对象天生为单例
    INSTANCE;
    private final StrategyExecute strategyExecute;

    /**
     * 私有化枚举的构造函数
     */
    StrategyExecuteSingletonEnum() {
        //Bean注入，可在此类中使用spring管理的bean:SpringBeanFactoryUtils.getBean(StrategyExecute.class)
        strategyExecute = new StrategyExecute();
    }

    public StrategyExecute getInstance(){
        return strategyExecute;
    }
}
