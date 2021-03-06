package just.met.springboot.feign.eneity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangmaogang
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(Result.class);

    public Result() {
        this.put((String)"code", 0);
        this.put((String)"msg", "操作成功");
    }

    public static Result error() {
        return error(1, "操作失败");
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put((String)"code", code);
        r.put((String)"msg", msg);
        return r;
    }

    public static Result ok(String msg) {
        Result r = new Result();
        r.put((String)"msg", msg);
        return r;
    }

    public static Result ok(Map<String, Object> map) {
        Result r = new Result();
        r.putAll(map);
        return r;
    }

    public static Result ok() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
