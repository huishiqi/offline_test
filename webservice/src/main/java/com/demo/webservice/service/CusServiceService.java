package com.demo.webservice.service;

import com.demo.webservice.model.Customer;

import java.util.List;

public interface CusServiceService {
    List<Customer> listAllSubscribedCustomerByServiceId(int serviceId) throws Exception;
}
