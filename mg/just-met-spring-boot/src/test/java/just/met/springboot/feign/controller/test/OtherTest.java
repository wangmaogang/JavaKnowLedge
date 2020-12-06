package just.met.springboot.feign.controller.test;

import org.junit.Test;

import java.io.File;

public class OtherTest {


    @Test
    public void feignTest() {
        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\report\\"+"报告空白模板.doc";
        System.out.println(filepath);
        File file = new File(filepath);
        if(file.exists()){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}