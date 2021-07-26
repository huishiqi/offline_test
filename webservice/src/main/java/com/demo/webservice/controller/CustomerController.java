package com.demo.webservice.controller;

import com.demo.webservice.common.Response;
import com.demo.webservice.common.customer.SimpleCustomer;
import com.demo.webservice.common.customer.SubscribeCusServiceRespData;
import com.demo.webservice.common.customer.UnSubscribeCusServiceRespData;
import com.demo.webservice.consts.StatusCode;
import com.demo.webservice.converter.CustomerConverter;
import com.demo.webservice.model.CusService;
import com.demo.webservice.model.Customer;
import com.demo.webservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = {"/{customerId}/get"})
    public Response<SimpleCustomer> getCustomerById(@PathVariable("customerId") int customerId) throws Exception {
        Response<SimpleCustomer> resp = new Response<>();
        Customer customer = customerService.getCustomerById(customerId);

        resp.setStatusCode(StatusCode.SUCCESS.getCode());
        resp.setMessage(StatusCode.SUCCESS.getMsg());
        resp.setData(CustomerConverter.convertCustomerToSimpleCustomer(customer));
        return resp;
    }

    @PostMapping(path = {"/{customerId}/subscribe/{serviceId}"})
    public Response<SubscribeCusServiceRespData> subscribeCusService(@PathVariable("customerId") int customerId, @PathVariable("serviceId") int serviceId) throws Exception {
        Response<SubscribeCusServiceRespData> resp = new Response<>();
        boolean success = customerService.subscribeService(customerId, serviceId);

        resp.setStatusCode(StatusCode.SUCCESS.getCode());
        resp.setMessage(StatusCode.SUCCESS.getMsg());
        resp.setData(new SubscribeCusServiceRespData(success));
        return resp;
    }

    @PostMapping(path = {"/{customerId}/unSubscribe/{serviceId}"})
    public Response<UnSubscribeCusServiceRespData> unSubscribeCusService(@PathVariable("customerId") int customerId, @PathVariable("serviceId") int serviceId) throws Exception {
        Response<UnSubscribeCusServiceRespData> resp = new Response<>();
        boolean success = customerService.unSubscribeService(customerId, serviceId);

        resp.setStatusCode(StatusCode.SUCCESS.getCode());
        resp.setMessage(StatusCode.SUCCESS.getMsg());
        resp.setData(new UnSubscribeCusServiceRespData(success));
        return resp;
    }

    @GetMapping(path = {"/{customerId}/subscribedServices/list"})
    public Response<List<CusService>> getAllSubscribedServices(@PathVariable("customerId") int customerId) throws Exception {
        Response<List<CusService>> resp = new Response<>();
        List<CusService> subscribedServices = customerService.listAllSubscribedService(customerId);

        resp.setStatusCode(StatusCode.SUCCESS.getCode());
        resp.setMessage(StatusCode.SUCCESS.getMsg());
        resp.setData(subscribedServices);
        return resp;
    }

}
