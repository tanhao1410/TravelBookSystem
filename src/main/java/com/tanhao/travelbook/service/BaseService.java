package com.tanhao.travelbook.service;

import com.github.abel533.mapper.Mapper;

import java.util.List;

public abstract class BaseService<T> {

    protected abstract Mapper<T> getMapper();

    public List<T> getAll() throws Exception{
        return this.getMapper().select(null);
    }

    public List<T> gg(Object o) throws Exception{
        return this.getMapper().selectByExample(o);
    }

    public T getById(Object id)throws Exception{
        return this.getMapper().selectByPrimaryKey(id);
    }

    public void deleteById(String id) throws Exception{
        this.getMapper().deleteByPrimaryKey(id);
    }

    public int create(T t)throws Exception{
        return this.getMapper().insert(t);
    }

    public T update(T t)throws Exception{
        return this.update(t);
    }
}
