package com.demo.webservice.controller;

import com.demo.webservice.common.Response;
import com.demo.webservice.common.customer.SimpleCustomer;
import com.demo.webservice.consts.StatusCode;
import com.demo.webservice.converter.CustomerConverter;
import com.demo.webservice.model.Customer;
import com.demo.webservice.service.CusServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cusService")
public class CusServiceController {

    @Autowired
    private CusServiceService cusServiceService;

    @GetMapping(path = {"/{serviceId}/subscribedCustomer/list"})
    public Response<List<SimpleCustomer>> getAllSubscribedCustomerByServiceId(@PathVariable("serviceId") int serviceId) throws Exception {
        Response<List<SimpleCustomer>> resp = new Response<>();
        List<Customer> allCustomers = cusServiceService.listAllSubscribedCustomerByServiceId(serviceId);

        resp.setStatusCode(StatusCode.SUCCESS.getCode());
        resp.setMessage(StatusCode.SUCCESS.getMsg());
        resp.setData(CustomerConverter.convertCustomerListToSimpleCustomerList(allCustomers));
        return resp;
    }

}
