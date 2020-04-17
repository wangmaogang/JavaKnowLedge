package just.met.designpattern.design4.impl1;

/**
 * 抽象算法类
 */
abstract class Strategy {
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
