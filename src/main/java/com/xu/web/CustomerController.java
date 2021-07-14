package com.xu.web;


import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xu.pojo.BaseDict;
import com.xu.pojo.CustomException;
import com.xu.pojo.Customer;
import com.xu.pojo.QueryVo;
import com.xu.service.BaseDictService;
import com.xu.service.CustomerService;
import com.xu.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @Value("${customer_from_type}")
    private String customer_from_type;
    @Value("${customer_industry_type}")
    private String customer_industry_type;
    @Value("${customer_level_type}")
    private String customer_level_type;

    @GetMapping(value = "/list")
    public String toMain(QueryVo queryVo, Model model) {
        List<BaseDict> fromType = baseDictService.findItemNameByTypeCode(customer_from_type);
        List<BaseDict> industryType = baseDictService.findItemNameByTypeCode(customer_industry_type);
        List<BaseDict> levelType = baseDictService.findItemNameByTypeCode(customer_level_type);

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);

        Page<Customer> page = customerService.findCustomerByCriteriaByPage(queryVo);
        model.addAttribute("page", page);

        return "customer";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String removeCustomerById(@RequestParam("id") String id) {
        customerService.removeCustomerById(id);
        return "abc";
    }

    @GetMapping("/edit")
    @ResponseBody
    public Object findCustomerById(@RequestParam("id") String id) {
        Customer customer = customerService.findCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/update")
    @ResponseBody
    public String updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return "abc";
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public String addCustomer(Customer customer) {
        customer.setCust_createtime(new Date(System.currentTimeMillis()));
        customerService.addCustomer(customer);
        return "abc";
    }
}
