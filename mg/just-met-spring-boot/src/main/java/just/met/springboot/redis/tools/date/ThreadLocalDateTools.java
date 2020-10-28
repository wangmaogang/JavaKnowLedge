package just.met.springboot.redis.tools.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程安全的Date格式时间转换
 * 解决问题：
 * 使用SimpleDataFormat的parse()方法，内部有一个Calendar对象，
 * 调用SimpleDataFormat的parse()方法会先调用Calendar.clear（），然后调用Calendar.add()，
 * 如果一个线程先调用了add()然后另一个线程又调用了clear()，这时候parse()方法解析的时间就不对了
 * @author wangmaogang
 */
public class ThreadLocalDateTools {

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();

    /**
     * 获取指定日期格式的format
     * @param type
     * @return
     */
    public static DateFormat getDateFormat(String type){
        DateFormat format = threadLocal.get();
        if(format == null){
            format = new SimpleDateFormat(type);
            threadLocal.set(format);
        }
        return format;
    }

    /**
     * date类型转指定格式的string
     * @param date
     * @param type
     * @return
     */
    public static String formatDate(Date date,String type){
        return getDateFormat(type).format(date);
    }

    /**
     * string类型转指定格式的date
     * @param strDate
     * @param type
     * @return
     */
    public static Date parse(String strDate,String type) throws ParseException {
        return getDateFormat(type).parse(strDate);
    }

}
