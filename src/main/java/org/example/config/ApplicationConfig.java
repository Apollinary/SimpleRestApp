package org.example.config;

import org.example.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class ApplicationConfig {
    @Bean
    public RedisTemplate<Long, User> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, User> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
