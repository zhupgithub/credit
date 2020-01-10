package com.zhupeng.common.sys.constant;

public enum ResultEnum {

    DEFAULT_SUCCESS(1000 , "调用成功"),
    DEFAULT_FAIL(9999 , "调用失败")
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
