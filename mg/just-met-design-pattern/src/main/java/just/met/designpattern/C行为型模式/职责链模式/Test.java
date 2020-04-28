package just.met.designpattern.C行为型模式.职责链模式;

/**
 * @author wangmaogang
 */
public class Test {

    public static void main(String[] args) {
        AbstractHandler handler1 = new ConcreteHandler1();
        AbstractHandler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        handler1.handleRequest("one");
        handler1.handleRequest("two");
        handler1.handleRequest("three");
    }

}
