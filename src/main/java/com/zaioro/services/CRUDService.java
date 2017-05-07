package com.zaioro.services;

import java.util.List;

/**
 * Created by Val on 2017-05-05.
 */
public interface CRUDService<T> {

    T getById(Integer id);
    List<?> listAll();
    T saveOrUpdate(T domainObject);
    void delete(Integer id);
}
