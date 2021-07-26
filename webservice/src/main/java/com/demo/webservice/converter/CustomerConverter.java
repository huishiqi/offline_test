package com.demo.webservice.converter;

import com.demo.webservice.common.customer.SimpleCustomer;
import com.demo.webservice.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerConverter {
    public static SimpleCustomer convertCustomerToSimpleCustomer(Customer customer) {
        return new SimpleCustomer(customer.getCustomerId(), customer.getUsername());
    }

    public static List<SimpleCustomer> convertCustomerListToSimpleCustomerList(List<Customer> customerList) {
        List<SimpleCustomer> list = new ArrayList<>();
        for (Customer c : customerList) {
            list.add(convertCustomerToSimpleCustomer(c));
        }
        return list;
    }
}
