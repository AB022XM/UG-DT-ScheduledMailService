/*
package ug.co.absa.notify.settings;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class AllKeysCache {

    @Bean
    CacheManager cacheManager() {
        return new CaffeineCacheManager();
    }

    @CachePut(cacheNames = "slowServiceCache", key = "#name")
    public String save(String name, String details) {
        return details;
    }
}
*/
