package just.met.springboot.设计模式结合Spring.ex;

/**
 * 策略执行异常处理类
 * @author noah
 */
public class StrategyFailedException
{
    /**
     * 策略执行失败
     */
    public static class FailedExecute extends Exception
    {
        public FailedExecute(String msg) {
            super(msg);
        }

        public FailedExecute(String msg,Exception e) {
            super(msg,e);
        }
    }
}

