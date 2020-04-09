package just.met.designpattern.design2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态内部类单例模式
 * @author wangmaogang
 */
public class Singleton {

    private static final Logger LOG = LoggerFactory.getLogger(Singleton.class);

    private Singleton(){
        LOG.debug("Singleton构造方法");
    }

    public static Singleton getInstance(){
        LOG.debug("getInstance()静态方法");
        return Holder.singleton;
    }

    private static class Holder{
        static{
            LOG.debug("Holder静态方法块");
        }

        private static final Singleton singleton = new Singleton();
    }

}
