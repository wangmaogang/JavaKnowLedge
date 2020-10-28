package just.met.javabase.正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangmaogang
 */
public class RegularTools {

    public static final String NO_MATCH = "NO MATCH";

    /**
     * 获取源字符串内,第一个符合正则表达式的字符串
     * @param originalStr 源字符串，即需要查找的字符串
     * @param pattern 正则表达式
     * @return 如果获取到，则返回匹配到的第一个字符串，如果没有，则返回NO MATCH
     */
    public static String getFirstMatchStr(String originalStr,String pattern){
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(originalStr);
        if (m.find( )) {
            return m.group(1);
        } else {
            return NO_MATCH;
        }
    }

}
