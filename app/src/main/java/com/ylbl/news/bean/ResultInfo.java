package com.ylbl.news.bean;

import java.util.List;

public class ResultInfo<T> {
    private String reason;
    private Result result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
