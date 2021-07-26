package com.demo.webservice.common.customer;

public class UnSubscribeCusServiceRespData {
    private boolean success;

    public UnSubscribeCusServiceRespData() { }

    public UnSubscribeCusServiceRespData(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
