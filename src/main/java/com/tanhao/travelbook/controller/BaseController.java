package com.tanhao.travelbook.controller;

import com.alibaba.fastjson.JSONObject;
import com.tanhao.travelbook.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
            this.getService().deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
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