package just.met.designpattern.C行为型模式.职责链模式;

/**
 * 具体处理者角色2
 * @author wangmaogang
 */
public class ConcreteHandler2 extends AbstractHandler {

    private String type = "two";

    @Override
    public void handleRequest(String request) {
        if(type.equals(request)){
            System.out.println("ConcreteHandler2处理该请求成功!");
        }
        else {
            if(this.getNext()!=null){
                this.getNext().handleRequest(request);
            }
            else{
                System.out.println("没有角色处理该请求!");
            }
        }
    }
}
