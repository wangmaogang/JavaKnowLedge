package just.met.javabase.动态代理.cglib动态代理;

import just.met.javabase.动态代理.jdk动态代理.ISubject;
import just.met.javabase.动态代理.jdk动态代理.JdkDynamicProxy;
import just.met.javabase.动态代理.jdk动态代理.RealSubject;
import org.apache.commons.collections.MapUtils;

import java.util.*;

/**
 * @author wangmaogang
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = {4,2,2,1,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        List<Integer> list = new ArrayList<>();

        Collections.sort(list);

        List<Integer> list2 = new LinkedList();

        Collections.sort(list2);

        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums){
            int count  = map.get(num) == null ? 0 : map.get(num);
            map.put(num,++count);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer value = entry.getValue();
            if(value.equals(1)){
                return entry.getKey();
            }
        }
        return 0;
    }
}

