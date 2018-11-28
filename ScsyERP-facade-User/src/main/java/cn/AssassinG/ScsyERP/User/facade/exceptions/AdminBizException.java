package cn.AssassinG.ScsyERP.User.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class AdminBizException extends BizException {

    public static final int ADMINBIZ_UNKNOWN_ERROR   = 11020000;//未知错误
    public static final int ADMINBIZ_PARAMS_ILLEGAL  = 11020001;//参数不合法
    public static final int ADMINBIZ_DBUNIQUE_ERROR  = 11020002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int ADMINBIZ_NOSUIT_RESULT   = 11020003;//没有找到符合条件的记录以进行下一步操作
    public static final int ADMINBIZ_NOPERMISSION    = 11020004;//没有权限
    public static final int ADMINBIZ_CANNOTOPERATE   = 11020005;//无法操作，比如用户名重复等

    public AdminBizException(){super();}
    public AdminBizException(int code, String msg) {
        super(code, msg);
    }
    public AdminBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
