package com.demo.webservice.common.customer;

public class SubscribeCusServiceRespData {
    private boolean success;

    public SubscribeCusServiceRespData() {
    }

    public SubscribeCusServiceRespData(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
