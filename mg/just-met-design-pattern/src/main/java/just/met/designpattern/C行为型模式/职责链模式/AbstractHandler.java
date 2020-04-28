package just.met.designpattern.C行为型模式.职责链模式;

/**
 * 抽象处理者角色
 * @author wangmaogang
 */
public abstract class AbstractHandler {

    private AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public AbstractHandler getNext() {
        return next;
    }

    /***
     * 处理请求的方法
     * @param request
     */
    public abstract void handleRequest(String request);
}
