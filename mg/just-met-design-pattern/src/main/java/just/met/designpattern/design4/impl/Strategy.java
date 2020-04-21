package just.met.designpattern.design4.impl;

/**
 * 抽象算法类
 */
public abstract class Strategy {
    /**
     * 算法方法
     */
    public abstract void AlgorithmInterface();

    /**
     * 当前算法类型
     * @return
     */
    public abstract String getType();
}
