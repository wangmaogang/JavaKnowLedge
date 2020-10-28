package just.met.javabase.NIO;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author wangmaogang
 */
public class Reactor implements Runnable{

    private static Logger log = LoggerFactory.getLogger(Reactor.class);

    /**
     * 多路复用器
     */
    final Selector selector;

    /**
     * 通道
     */
    final ServerSocketChannel channel;

    /**
     * server是否停止，默认为false
     */
    private volatile boolean stop;

    /**
     * Reactor的构造方法，启动一个Reactor系统
     * 启动的时候把当前的 serverSocket 注册到给定的selector，并且指明感兴趣的事件SelectionKey.OP_ACCEPT，
     * 然后返回一个SelectionKey，这个key表示当前的channel 和 selector的映射关系
     * @param port
     * @throws IOException
     */
    public Reactor(int port) throws IOException {
        //创建多路复用器selector，工厂方法
        selector = Selector.open();
        //创建ServerSocketChannel，工厂方法
        channel = ServerSocketChannel.open();
        //绑定ip和端口号，默认的IP=127.0.0.1，对连接的请求最大队列长度设置为backlog=1024，如果队列满时收到连接请求，则拒绝连接
        channel.socket().bind(
                new InetSocketAddress(port),1024);
        //设置非阻塞方式
        channel.configureBlocking(false);
        //注册serverSocketChannel到selector多路服用器上面，监听accrpt请求
        SelectionKey sk =
                channel.register(selector,
                        SelectionKey.OP_ACCEPT);
        //利用sk的attache功能绑定Acceptor 如果有事情，触发Acceptor
        sk.attach(new Acceptor());
        log.info("sk.attach(new Acceptor())-success");
    }

    /**
     * 如果现在有一个网络连接，如果网络的OP_ACCEPT事件发生，则调用selector.selectedKeys()会得到一个关于OP_ACCEPT事件的key，然后dispatch(sk)分发这个事件。
     */
    @Override
    public void run() {
        try {
            while (!stop) {
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                //Selector如果发现channel有OP_ACCEPT或READ事件发生，下列遍历就会进行。
                while (it.hasNext()) {
                    //一个事件,第一次触发一个accepter线程,以后触发Handler
                    SelectionKey sk = (SelectionKey) it.next();
                    log.info("acceptable=" + sk.isAcceptable() +
                            ",readable=" + sk.isReadable() +
                            ",writable=" + sk.isWritable());
                    dispatch(sk);
                }
                selected.clear();
            }
        } catch (IOException ex) {
            log.info("reactor stop!" + ex);
        }
    }

    /**
     * 通过key的attachment()方法得到附加的对象，这个对象是一个线程对象，也就是Acceptor对象
     * @param k
     */
    void dispatch(SelectionKey k) {
        log.info("dispatch - start");
        Runnable r = (Runnable) (k.attachment());
        if (r != null) {
            r.run();
        }
    }

    /**
     * 在这里处理网络连接，得到客户端的socketchannel
     */
    class Acceptor implements Runnable { // inner
        @Override
        public void run() {
            try {
                log.info("Acceptor run()");
                SocketChannel c = channel.accept();
                if (c != null) {
                    new Handler(selector, c);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 停止当前服务
     */
    public void stop(){
        this.stop = true;
    }

}
