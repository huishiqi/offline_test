package com.demo.webservice.common.customer;

public class SimpleCustomer {
    private int customerId;
    private String username;

    public SimpleCustomer(int customerId, String username) {
        this.customerId = customerId;
        this.username = username;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
