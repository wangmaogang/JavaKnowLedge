package just.met.springboot.idemp.eneity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmaogang
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(R.class);

    public R() {
        this.put((String)"code", 0);
        this.put((String)"msg", "操作成功");
    }

    public static R error() {
        return error(1, "操作失败");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put((String)"code", code);
        r.put((String)"msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put((String)"msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static boolean isSuccess(Map<String, Object> map) {
        int code = (int)map.get("code");
        return code == 0;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
