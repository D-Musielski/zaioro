package com.zaioro.services;

/**
 * Created by Val on 2017-05-15.
 */
import java.util.List;

public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
