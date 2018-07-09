package com.boot.quartz.multiplejobs.entity.baseEntity;

import java.io.Serializable;

/**
 * Created by zou on 2018/7/10.
 */
public class RecordsToDbEntity implements Serializable{
    private final static long serialVersionUID=1L;
    private String requestParam;
    private String responseResult;
    private String businessId;

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(String responseResult) {
        this.responseResult = responseResult;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
