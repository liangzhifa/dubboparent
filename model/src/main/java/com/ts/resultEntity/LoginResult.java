package com.ts.resultEntity;

import java.io.Serializable;
import java.util.Map;

public class LoginResult implements Serializable{
    private Integer code;
    private Object data;

    public LoginResult() {
    }

    public LoginResult(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static LoginResult SUCCESS(Map<Object,Object>map){
        LoginResult loginResult=new LoginResult(0,map);
        return loginResult;
    }
    public static LoginResult ERROR(Map<Object,Object>map){
        LoginResult loginResult=new LoginResult(1,map);
        return loginResult;
    }
}
