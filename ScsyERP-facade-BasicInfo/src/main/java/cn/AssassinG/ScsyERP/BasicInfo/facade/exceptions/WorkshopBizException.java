package cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions;

import cn.AssassinG.ScsyERP.common.exceptions.BizException;

public class WorkshopBizException extends BizException {

    public static final int WORKSHOPBIZ_UNKNOWN_ERROR   = 12020000;//未知错误
    public static final int WORKSHOPBIZ_PARAMS_ILLEGAL  = 12020001;//参数不合法
    public static final int WORKSHOPBIZ_DBUNIQUE_ERROR  = 12020002;//应该返回唯一数据的查询查询到多个数据，程序无法处理
    public static final int WORKSHOPBIZ_NOSUIT_RESULT   = 12020003;//没有找到符合条件的记录以进行下一步操作
    public static final int WORKSHOPBIZ_NOPERMISSION    = 12020004;//没有权限
    public static final int WORKSHOPBIZ_CANNOTOPERATE   = 12020005;//无法操作，比如用户名重复等

    public WorkshopBizException(){super();}
    public WorkshopBizException(int code, String msg) {
        super(code, msg);
    }
    public WorkshopBizException(int code, String msgFormat, Object... args) {
        super(code, msgFormat, args);
    }
}
