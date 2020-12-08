package just.met.springboot.状态机与实际项目.service;

import just.met.springboot.idemp.eneity.R;
import just.met.springboot.状态机与实际项目.define.AgreementStatus;
import just.met.springboot.状态机与实际项目.define.AgreementStatusChangeEvent;
import just.met.springboot.状态机与实际项目.eneity.Agreement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("agreementServiceUpdate")
@Slf4j
public class AgreementServiceUpdateImpl implements AgreementServiceUpdate {


    @Override
    public R save(Agreement agreement) {
        log.debug("[update]Agreement-save");
        //模拟耗时操作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.ok();
    }

    @Override
    public R submit(Agreement agreement) {
        //模拟耗时操作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.ok();
    }

    @Override
    public R refuse(Agreement agreement) {
        //模拟耗时操作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.ok();
    }

    @Override
    public R confirm(Agreement agreement) {
        //模拟耗时操作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.ok();
    }

    @Override
    public R complete(Agreement agreement) {
        //模拟耗时操作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.ok();
    }
}