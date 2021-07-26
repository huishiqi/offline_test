package com.demo.webservice.dao;

import com.demo.webservice.model.CusService;
import com.demo.webservice.model.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerDao {
    @Select("SELECT * FROM customer WHERE customer_id=#{customerId}")
    @Results({@Result(property = "customerId", column = "customer_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
    })
    Customer getCustomerById(@Param("customerId") int customerId);

    @Select("SELECT * FROM service WHERE service_id IN " +
            "(SELECT service_id FROM customer_service_relation WHERE customer_id=#{customerId})")
    @Results({
            @Result(property = "serviceId", column = "service_id"),
            @Result(property = "serviceName", column = "service_name"),
    })
    List<CusService> listAllSubscribedService(@Param("customerId") int customerId);
}
