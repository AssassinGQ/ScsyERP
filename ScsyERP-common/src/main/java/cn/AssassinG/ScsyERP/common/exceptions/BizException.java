package cn.AssassinG.ScsyERP.common.exceptions;

public class BizException extends RuntimeException {
    /**
     * 业务异常基类，所有业务异常都必须继承于此异常
     *         定义异常时，需要先确定异常所属模块。例如：添加商户报错 可以定义为 [10020001] 前四位数为系统模块编号，后4位为错误代码 ,唯一 <br>
     *         用户信息     1001 <br>
     *         基本信息     1002 <br>
     *         入库业务     1004 <br>
     *         出库业务     1008 <br>
     *         在途跟踪业务 1011 <br>
     *         费用结算业务 1012 <br>
     *         数据统计业务 1014 <br>
     *         管理网页门户 1018 <br>
     */

    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 具体异常码
     */
    protected int code;

    public BizException(int code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
        this.msg = String.format(msgFormat, args);
    }

    public BizException() {
        super();
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    /**
     * 实例化异常
     *
     * @param msgFormat
     * @param args
     * @return
     */
    public BizException newInstance(String msgFormat, Object... args) {
        return new BizException(this.code, msgFormat, args);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message) {
        super(message);
    }
}
