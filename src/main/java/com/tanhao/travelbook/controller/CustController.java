package com.tanhao.travelbook.controller;

import com.alibaba.fastjson.JSONObject;
import com.tanhao.travelbook.bean.Car;
import com.tanhao.travelbook.bean.Customer;
import com.tanhao.travelbook.service.BaseService;
import com.tanhao.travelbook.service.CarService;
import com.tanhao.travelbook.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RequestMapping("/customer")
@Controller
class CustController extends BaseController<Customer>{

    @Autowired
    private CustService custService;//service注入

    @Override
    protected BaseService<Customer> getService() {
        return this.custService;
    }


}