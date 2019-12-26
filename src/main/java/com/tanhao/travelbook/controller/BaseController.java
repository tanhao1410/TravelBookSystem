package com.tanhao.travelbook.controller;

import com.alibaba.fastjson.JSONObject;
import com.tanhao.travelbook.bean.Customer;
import com.tanhao.travelbook.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 所有Controller的基类，继承此类后，基本的增删改查通用web接口即已实现
 * @param <T> 哪个Controller就是哪个类
 */
abstract class BaseController <T>{


    /**
     * 子类必须实现，返回注入的对应的服务类即可
     * @return
     */
    abstract protected BaseService<T> getService();


    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getOneById(@PathVariable("id") String id) {
        try {
            id = new String(id.getBytes("ISO-8859-1"), "utf-8");
            T result = this.getService().getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @ResponseBody
    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity getAll() {
        try {
            List<T> result = this.getService().getAll();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @ResponseBody
    @RequestMapping( "/delete")
    public ResponseEntity delete(@RequestParam("id") String id) {
        try {
            id = new String(id.getBytes("ISO-8859-1"), "utf-8");
            this.getService().deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @ResponseBody
    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody String json) {
        try {

            Map result = new HashMap();
            T t =(T)JSONObject.parseObject(json);
            this.getService().create(t);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @ResponseBody
    @RequestMapping( value = "/update" ,method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody String json) {
        try {
            T flight = (T)JSONObject.parseObject(json);
            this.getService().update(flight);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}