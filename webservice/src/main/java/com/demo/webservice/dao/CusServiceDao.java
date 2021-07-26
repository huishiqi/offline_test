package com.demo.webservice.dao;

import com.demo.webservice.model.CusService;
import com.demo.webservice.model.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CusServiceDao {

    @Select("SELECT * FROM service WHERE service_id=#{serviceId}")
    @Results({@Result(property = "serviceId", column = "service_id"),
            @Result(property = "serviceName", column = "service_name"),
    })
    CusService getServiceById(@Param("serviceId") int serviceId);

    @Select("SELECT customer_id, username, password FROM customer WHERE customer_id IN " +
            "(SELECT customer_id FROM customer_service_relation WHERE service_id=#{serviceId})")
    @Results({@Result(property = "customerId", column = "customer_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
    })
    List<Customer> listAllSubscribedCustomerByServiceId(@Param("serviceId") int serviceId);
}
