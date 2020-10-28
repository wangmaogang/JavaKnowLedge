package just.met.springboot.redis.tools.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * LocalData时间工具类
 * @author wangmaogang
 */
public class LocalDataConvertTools {

    /**
     * yyyy-mm-dd格式日期
     * 1、DateTimeFormatter.ISO_LOCAL_DATE :输出2020-04-17
     * 2、DateTimeFormatter.BASIC_ISO_DATE :输出20200417
     * @return
     */
    public static String getNowData(DateTimeFormatter dateTimeFormatter){
        LocalDate localDate = LocalDate.now();
        return localDate.format(dateTimeFormatter);
    }

    /**
     * 转换为string类型的日期
     * @return
     */
    public static String getDateStr(LocalDate date,String type){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(type);
        return date.format(fmt);
    }

}
