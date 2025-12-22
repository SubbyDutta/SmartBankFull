package backend.backend.configuration;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory("redis", 6379);
    }

    @Bean
    public ObjectMapper redisObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper;
    }

    @Bean
    public RedisCacheManager cacheManager(
            RedisConnectionFactory connectionFactory,
            ObjectMapper redisObjectMapper
    ) {

        GenericJackson2JsonRedisSerializer serializer =
                new GenericJackson2JsonRedisSerializer(redisObjectMapper);

        RedisCacheConfiguration defaultConfig =
                RedisCacheConfiguration.defaultCacheConfig()
                        .serializeValuesWith(
                                RedisSerializationContext.SerializationPair
                                        .fromSerializer(serializer)
                        )
                        .disableCachingNullValues();

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaultConfig)
                .withCacheConfiguration("transactions:user",
                        defaultConfig.entryTtl(Duration.ofMinutes(20)))
                .withCacheConfiguration("transactions:all",
                        defaultConfig.entryTtl(Duration.ofMinutes(15)))
                .withCacheConfiguration("user",
                        defaultConfig.entryTtl(Duration.ofMinutes(10)))
                .withCacheConfiguration("users:all",
                        defaultConfig.entryTtl(Duration.ofMinutes(10)))
                .withCacheConfiguration("balance",
                        defaultConfig.entryTtl(Duration.ofSeconds(10)))
                .withCacheConfiguration("score",
                        defaultConfig.entryTtl(Duration.ofMinutes(15)))
                .withCacheConfiguration("repaylist",
                        defaultConfig.entryTtl(Duration.ofMinutes(10)))
                .withCacheConfiguration("accountNumber",
                        defaultConfig.entryTtl(Duration.ofDays(10)))
                .withCacheConfiguration("loanApplications:all",
                        defaultConfig.entryTtl(Duration.ofDays(10)))
                .withCacheConfiguration("pendingapplications:all",
                        defaultConfig.entryTtl(Duration.ofDays(10)))
                .withCacheConfiguration("UserApprovedLoan",
                        defaultConfig.entryTtl(Duration.ofDays(10)))
                .withCacheConfiguration("BankAccountResponseDto",
                        defaultConfig.entryTtl(Duration.ofDays(10)))
                .withCacheConfiguration("accounts:all",
                        defaultConfig.entryTtl(Duration.ofDays(10)))

                .withCacheConfiguration("existsuser",
                        defaultConfig.entryTtl(Duration.ofDays(10)))
                .build();
    }
}
