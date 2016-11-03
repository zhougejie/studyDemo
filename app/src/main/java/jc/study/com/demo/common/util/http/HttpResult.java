package jc.study.com.demo.common.util.http;

/**
 * 通用的Http结果返回类
 * 创建人: ZHOU Ge Jie
 * 创建日期: 2016/10/31
 */
public class HttpResult<T> {

    private int resultCode;

    private String resultMessage;

    private T data;


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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
