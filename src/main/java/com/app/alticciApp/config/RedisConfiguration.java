package com.app.alticciApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.app.alticciApp.domain.AlticciDomain;

@Configuration
public class RedisConfiguration {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, AlticciDomain> redisTemplate() {
        final RedisTemplate<String, AlticciDomain> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
