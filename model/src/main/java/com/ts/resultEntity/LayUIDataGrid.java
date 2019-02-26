package com.ts.resultEntity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LayUIDataGrid implements Serializable {

    /**
     * code : 0
     * msg :
     * count : 1000
     * data : [null,"\u2026"]
     */

    private int code;
    private String msg;
    private Long count;
    private List data;

    public LayUIDataGrid() {
    }

    public LayUIDataGrid(long count, List data) {
        this.count = count;
        this.data = data;
        this.code=0;
        this.msg="请求成功！";
    }
    public static LayUIDataGrid ReturnDataGrid(long count, List data){

        return new LayUIDataGrid(count,data);
    }
    public static LayUIDataGrid ReturnERRODataGrid(){

        LayUIDataGrid layUIDataGrid = new LayUIDataGrid();

        layUIDataGrid.setCode(1);
        layUIDataGrid.setCount(0l);
        layUIDataGrid.setMsg("请求失败，或者没登录");
        layUIDataGrid.setData(new ArrayList());
        return layUIDataGrid;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
