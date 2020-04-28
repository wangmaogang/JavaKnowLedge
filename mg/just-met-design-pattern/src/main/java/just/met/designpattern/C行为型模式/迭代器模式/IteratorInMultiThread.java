package just.met.designpattern.C行为型模式.迭代器模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Iterator不是线程安全
 */
public class IteratorInMultiThread {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10000;i++){
            list.add(i);
        }

        ExecutorService es = Executors.newFixedThreadPool(5);
        final Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(it.next());
                }
            });
        }

        es.shutdown();
    }
}
