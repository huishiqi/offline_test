package com.demo.webservice.service;

import com.demo.webservice.model.CusService;
import com.demo.webservice.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(int customerId) throws Exception;

    boolean subscribeService(int customerId, int serviceId) throws Exception;

    boolean unSubscribeService(int customerId, int serviceId) throws Exception;

    List<CusService> listAllSubscribedService(int customerId) throws Exception;
}
