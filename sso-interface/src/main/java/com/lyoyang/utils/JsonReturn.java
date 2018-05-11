package com.lyoyang.utils;

import java.io.Serializable;

/**
 * @author jimband
 */

public class JsonReturn implements Serializable {
    /**
     * 成功标识
     */
    private static final String SUCCESS = "0";
    /**
     * 错误标识
     */
    private static final String ERROR = "-1";
    /**
     * 异常标识
     */
    private static final String EXCEPTION = "-2";
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5701060215880308437L;

    /**
     * 错误代码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;


    public static JsonReturn successInstance(Object data) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setCode(SUCCESS);
        jsonReturn.setData(data);
        return jsonReturn;
    }

    public static JsonReturn successInstance() {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setCode(SUCCESS);
        return jsonReturn;
    }

    public static JsonReturn errorInstance(String msg) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setCode(ERROR);
        jsonReturn.setMsg(msg);
        return jsonReturn;
    }

    public static JsonReturn errorInstance() {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setCode(ERROR);
        return jsonReturn;
    }

    public static JsonReturn createFailureResult(String code) {
        JsonReturn jsonReturn = new JsonReturn();
        return createFailureResult(code, "");
    }

    public static JsonReturn createFailureResult(String code, String msg) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setCode(code);
        jsonReturn.setMsg(msg);
        return jsonReturn;

    }

    public static JsonReturn createSuccessResult(String code) {
        return createSuccessResult(code, null);
    }

    public static JsonReturn createSuccessResult(String code, Object data) {
        JsonReturn jsonReturn = new JsonReturn();
        jsonReturn.setCode(code);
        jsonReturn.setData(data);
        return jsonReturn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
