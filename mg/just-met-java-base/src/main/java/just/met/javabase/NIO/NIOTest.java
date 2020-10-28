package just.met.javabase.NIO;

import java.io.*;

/**
 * @author wangmaogang
 */
public class NIOTest {

    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor(9098);
        reactor.run();

        File file = null;
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
    }
}
