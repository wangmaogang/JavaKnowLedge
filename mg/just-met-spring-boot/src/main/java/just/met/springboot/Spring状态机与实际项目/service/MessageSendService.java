package just.met.springboot.Spring状态机与实际项目.service;

import just.met.springboot.idemp.eneity.R;
import just.met.springboot.Spring状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.Spring状态机与实际项目.eneity.Agreement;
import org.springframework.messaging.Message;

public interface MessageSendService {

    /**
     * 发送
     *
     * @param event 事件
     * @param agreement 协议
     * @return 是否成功
     */
    R send(AgreementStatusChangeEvent event, Agreement agreement);

    /**
     * 具体的发送委托协议状态转换事件
     *
     * @param message 消息
     * @param agreement 协议
     * @return 是否成功
     */
    boolean sendMessage(Message<AgreementStatusChangeEvent> message, Agreement agreement);
}
