package com.app.alticciApp.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.app.alticciApp.domain.AlticciDomain;

@Repository
public class AlticciRepository implements RedisRepository {
    
    private static final String KEY = "Alticc";
    
    private RedisTemplate<String, AlticciDomain> redisTemplate;
    private HashOperations hashOperations;

    public AlticciRepository(RedisTemplate<String, AlticciDomain> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, AlticciDomain> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public AlticciDomain findById(String id) {
        return (AlticciDomain) hashOperations.get(KEY, id);
    }

    @Override
    public void save(AlticciDomain alticciDomain,String number) {
        hashOperations.put(KEY, number, alticciDomain);
        
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
        
    }

}
