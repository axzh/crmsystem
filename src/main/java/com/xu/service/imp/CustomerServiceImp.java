package com.xu.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xu.mapper.CustomerMapper;
import com.xu.pojo.Customer;
import com.xu.pojo.QueryVo;
import com.xu.service.CustomerService;
import com.xu.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerMapper mapper;

    @Override
    public Page<Customer> findCustomerByCriteriaByPage(QueryVo vo) {
        PageHelper.startPage(vo.getPage(), vo.getRows());
        List<Customer> customers = mapper.findCustomerByCriteriaByPage(vo);
        //船舰PageInf对象，改对象中包含分页的最终结果
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers);
        Page<Customer> page = new Page<Customer>((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList());
        return page;
    }

    @Override
    public int findCountByCriteriaByPage(QueryVo vo) {
        return mapper.findCountByCriteriaByPage(vo);
    }

    @Override
    public void removeCustomerById(String id) {
        mapper.removeCustomerById(id);
    }

    @Override
    public Customer findCustomerById(String id) {
        return mapper.findCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        mapper.updateCustomer(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        mapper.addCustomer(customer);
    }
}
