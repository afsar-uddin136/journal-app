package com.afsar.myFirstProject.cache;

import com.afsar.myFirstProject.entity.ConfigJournalApp;
import com.afsar.myFirstProject.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    public enum Keys{
        WEATHER_API
    }

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    public Map<String,String> APP_CACHE;

    @PostConstruct
    public void init(){
        APP_CACHE=new HashMap<>();
        List<ConfigJournalApp> all = configJournalAppRepository.findAll();
        for(ConfigJournalApp configJournalApp : all){
            APP_CACHE.put(configJournalApp.getKey(),configJournalApp.getValue());
        }

    }
}
