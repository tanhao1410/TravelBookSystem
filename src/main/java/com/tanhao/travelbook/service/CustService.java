package com.tanhao.travelbook.service;

import com.github.abel533.mapper.Mapper;
import com.tanhao.travelbook.bean.Car;
import com.tanhao.travelbook.bean.Customer;
import com.tanhao.travelbook.dao.CarMapper;
import com.tanhao.travelbook.dao.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustService extends BaseService<Customer>{

    @Autowired
    private CustomerMapper mapper;

    @Override
    protected Mapper<Customer> getMapper() {
        return this.mapper;
    }


}
