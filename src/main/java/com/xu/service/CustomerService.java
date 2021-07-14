package com.xu.service;

import com.xu.pojo.Customer;
import com.xu.pojo.QueryVo;
import com.xu.utils.Page;


public interface CustomerService {

    Page<Customer> findCustomerByCriteriaByPage(QueryVo vo);

    int findCountByCriteriaByPage(QueryVo vo);

    void removeCustomerById(String id);

    Customer findCustomerById(String id);

    void updateCustomer(Customer customer);

    void addCustomer(Customer customer);
}
