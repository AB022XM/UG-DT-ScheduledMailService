/*
package ug.co.absa.notify.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tech.jhipster.config.JHipsterConstants;
import tech.jhipster.config.JHipsterDefaults;
import tech.jhipster.config.JHipsterProperties;
import ug.co.absa.notify.config.Constants;
import ug.co.absa.notify.domain.SchedulerSettings;
import ug.co.absa.notify.repository.SchedulerSettingsRepository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class Settings {

    public static final String JOB_NAME = "jobName";

    private SchedulerSettingsRepository schedulerSettingsRepository;

    @Autowired
    CacheManager cacheManager;



    public Settings(SchedulerSettingsRepository schedulerSettingsRepository) {
        this.schedulerSettingsRepository = schedulerSettingsRepository;
    }


    @Scheduled(fixedDelay = 30, initialDelay = 0,timeUnit = TimeUnit.SECONDS)
    protected void getAppsettings()
    {

        CaffeineCacheManager caffeineCacheManager = (CaffeineCacheManager) cacheManager;
        CaffeineCache cache = (CaffeineCache) caffeineCacheManager.getCache("slowServiceCache");
        Cache<Object, Object> caffeine = cache.getNativeCache();
        cacheManager.

        SchedulerSettings  appsettings=  schedulerSettingsRepository.findById(Constants.APP_ID).get();
        if(appsettings!=null)
        {
            var  jobName= appsettings.getId();

            JHipsterDefaults.Cache.Caffeine  cache = JHipsterDefaults.Cache.Caffeine.builder().build();
        }
    }


}


*/
