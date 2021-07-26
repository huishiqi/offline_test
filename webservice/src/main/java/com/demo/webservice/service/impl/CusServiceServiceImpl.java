package com.demo.webservice.service.impl;

import com.demo.webservice.dao.CusServiceDao;
import com.demo.webservice.model.Customer;
import com.demo.webservice.service.CusServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusServiceServiceImpl implements CusServiceService {

    @Autowired
    private CusServiceDao cusServiceDao;

    @Override
    public List<Customer> listAllSubscribedCustomerByServiceId(int serviceId) throws Exception {
        return cusServiceDao.listAllSubscribedCustomerByServiceId(serviceId);
    }

}
