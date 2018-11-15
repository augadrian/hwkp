package com.hwkp.dao;

import java.io.Serializable;

public interface BaseDao<T> {

    public T find(Class<T> clazz, Serializable id);

    public void delete(T t);

    public void update(T t);

    public void save(T t);
}
