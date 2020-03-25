package com.zhupeng.common.sys.constant;

public enum ResultEnum {

    DEFAULT_SUCCESS(1000 , "调用成功"),
    DEFAULT_FAIL(9999 , "调用失败"),
    PAGE_NULL(404, "请求页面不存在"),
    IO_ERROR(500, "流读取异常"),
    SERVICE_ERROR(500, "服务器异常"),
    REMOTE_SERVICE_NULL(404, "远程服务不存在");
    ;

    private ResultEnum(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    private int resultCode;

    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
