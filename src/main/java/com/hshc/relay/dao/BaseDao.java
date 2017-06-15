package com.hshc.relay.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDao<T, E>
{
    T selectOne(E e);

    List<T> selectList(E e);

    List<T> selectList(int rnFrom, int size, E e);

    int count(E e);

    int insert(T e);

    int batchInsert(List<T> tList);

    int update(T t);

    int delete(Integer id);

}
