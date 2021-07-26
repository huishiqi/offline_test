package com.demo.webservice.dao;

import org.apache.ibatis.annotations.*;

@Mapper
public interface CustomerServiceRelationDao {
    @Insert("INSERT INTO customer_service_relation (customer_id, service_id) VALUES (#{customerId}, #{serviceId})")
    int insertCustomerServiceRelation(@Param("customerId") int customerId, @Param("serviceId") int serviceId);

    @Delete("DELETE FROM customer_service_relation WHERE customer_id=#{customerId} and service_id=#{serviceId}")
    int deleteCustomerServiceRelation(@Param("customerId") int customerId, @Param("serviceId") int serviceId);
}
