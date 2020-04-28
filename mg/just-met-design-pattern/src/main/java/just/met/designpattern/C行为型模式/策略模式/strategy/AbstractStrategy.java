package just.met.designpattern.C行为型模式.策略模式.strategy;

/**
 * 抽象算法类
 * @author wangmaogang
 */
public abstract class AbstractStrategy {
    /**
     * 算法方法
     */
    public abstract void algorithmInterface();

    /**
     * 当前算法类型
     * @return
     */
    public abstract String getType();
}
