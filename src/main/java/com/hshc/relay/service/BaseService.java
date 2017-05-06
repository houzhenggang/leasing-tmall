package com.hshc.relay.service;

import com.hshc.relay.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class BaseService<T>{

    @Autowired
    protected BaseDao<T> baseDao;

    @Transactional(readOnly = true)
    public T getOne(T t){
        return baseDao.selectOne(t);
    }

    @Transactional(readOnly = true)
    public List<T> getList(T t){
        return baseDao.selectList(t);
    }

    @Transactional
    public int add(T t){
        return baseDao.insert(t);
    }

    @Transactional
    public int batchAdd(List<T> tList){
        return baseDao.batchInsert(tList);
    }

    @Transactional
    public int modify(T t){
        return baseDao.update(t);
    }

    @Transactional
    public int remove(Integer id){
        return baseDao.delete(id);
    }

}
