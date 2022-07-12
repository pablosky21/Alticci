package com.app.alticciApp.repository;

import java.util.Map;

import com.app.alticciApp.domain.AlticciDomain;

public interface RedisRepository {
    Map<String, AlticciDomain> findAll();
    AlticciDomain findById(String id);
    void save(AlticciDomain student,String number);
    void delete(String id);
}
