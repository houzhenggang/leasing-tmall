package com.hshc.relay.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDao<T>
{
    T selectOne(T t);

    List<T> selectList(T t);

    List<T> selectList(int rnFrom, int size, T t);

    int count(T t);

    int insert(T t);

    int batchInsert(List<T> tList);

    int update(T t);

    int delete(Integer id);

}
