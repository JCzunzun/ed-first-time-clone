package com.iesam.firsttime.features.vote.data;

import com.iesam.firsttime.features.appconfig.domain.AppConfig;
import com.iesam.firsttime.features.appconfig.domain.AppConfigRepository;

public class Stub2AppConfigDataRepository implements AppConfigRepository {

    @Override
    public AppConfig getAppConfig() {
        return new AppConfig(1);
    }

    @Override
    public void saveAppConfig(AppConfig appConfig) {

    }
}
