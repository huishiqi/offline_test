package com.demo.webservice.service.impl;

import com.demo.webservice.dao.CusServiceDao;
import com.demo.webservice.dao.CustomerDao;
import com.demo.webservice.dao.CustomerServiceRelationDao;
import com.demo.webservice.exception.DataNotFoundException;
import com.demo.webservice.model.CusService;
import com.demo.webservice.model.Customer;
import com.demo.webservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CusServiceDao cusServiceDao;

    @Autowired
    private CustomerServiceRelationDao customerServiceRelationDao;

    @Override
    public Customer getCustomerById(int customerId) throws Exception {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    @Transactional
    public boolean subscribeService(int customerId, int serviceId) throws Exception {
        Customer customer = customerDao.getCustomerById(customerId);
        CusService cusService = cusServiceDao.getServiceById(serviceId);
        if (customer == null || cusService == null) {
            throw new DataNotFoundException("customer or cusService not found");
        }
        return customerServiceRelationDao.insertCustomerServiceRelation(customerId, serviceId) == 1;
    }

    @Override
    @Transactional
    public boolean unSubscribeService(int customerId, int serviceId) throws Exception {
        Customer customer = customerDao.getCustomerById(customerId);
        CusService cusService = cusServiceDao.getServiceById(serviceId);
        if (customer == null || cusService == null) {
            throw new DataNotFoundException("customer or cusService not found");
        }
        return customerServiceRelationDao.deleteCustomerServiceRelation(customerId, serviceId) == 1;
    }

    @Override
    public List<CusService> listAllSubscribedService(int customerId) throws Exception {
        return customerDao.listAllSubscribedService(customerId);
    }

}
