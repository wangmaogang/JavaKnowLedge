package just.met.springboot.设计模式结合Spring.eneity;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求基本信息
 */
@Data
public class BaseRequestInfo {

    /**
     * request请求（带有相关参数）
     */
    private HttpServletRequest req;
    /**
     * 当前用户信息
     */
    private String currentUserId;
    /**
     * 当前用户信息
     */
    private String currentDeptId;
}
