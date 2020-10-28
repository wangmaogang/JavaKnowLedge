package just.met.javabase.NIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

final class Handler implements Runnable {
    private static Logger log = LoggerFactory.getLogger(Reactor.class);

    static final int MAXIN = 1024;
    static final int MAXOUT = 1024;
    final SocketChannel socket;
    final SelectionKey sk;
    ByteBuffer input = ByteBuffer.allocate(MAXIN);
    ByteBuffer output = ByteBuffer.allocate(MAXOUT);
    static final int READING = 0, SENDING = 1;
    int state = READING;

    /**
     * 得到了客户端的socketchannel，就可以准备读写客户端的socketchannel了。
     * 先注册一个SelectionKey.OP_READ读事件。并且当前的Handler对象附加到key对象上sk.attach(this);
     * @param selector
     * @param c
     * @throws IOException
     */
    Handler(Selector selector, SocketChannel c) throws IOException {
        socket = c;
        c.configureBlocking(false);
        // Optionally try first read now
        sk = socket.register(selector, 0);
        // 注意在Handler里面又执行了一次attach，这样，覆盖前面的Acceptor，
        // 下次该Handler又有READ事件发生时，
        // 将直接触发Handler.从而开始了数据的读->处理->写->发出等流程处理。
        sk.attach(this);
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    /**
     * 只是返回true，具体的判断没有实现
     * @return
     */
    boolean inputIsComplete() {
        return true;
    }

    /**
     * 只是返回true，具体的判断没有实现
     * @return
     */
    boolean outputIsComplete() {
        return true;
    }

    void process() { //没有具体实现
        output.put("helloworld".getBytes());
    }

    /**
     * 当READ事件发生后，则会通过dispatch(sk)分发。通过Handler的run方法进行具体的IO的读操作。
     */
    @Override
    public void run() {
        try {
            if (state == READING) {
                read();
            } else if (state == SENDING) {
                send();
            }
        } catch (IOException ex) { /* . . . */ }
    }

    /**
     * 读完了数据之后，注册OP_WRITE事件sk.interestOps(SelectionKey.OP_WRITE)。然后当该事件发生后，则分发该事件，调用Handler的run事件处理IO写操作。
     * @throws IOException
     */
    void read() throws IOException {
        log.info("read into bytebuffer from socketchannel inputs");
        socket.read(input);
        if (inputIsComplete()) {
            log.info("read complete");
            process();
            state = SENDING;
            // Normally also do first write now
            // 读完了数据之后，注册OP_WRITE事件
            sk.interestOps(SelectionKey.OP_WRITE);
        }
    }

    void send() throws IOException {
        log.info("write into socketchannel from bytebuffer outputs");
        socket.write(output);
        if (outputIsComplete()) {
            /**
             * The key will be removed fromall of the selector's key sets
             * during the next selection operation.
             */
            sk.cancel();
            socket.close(); //关闭通过，也就关闭了连接
            log.info("close socketchannel after write complete");
        }
    }
}
