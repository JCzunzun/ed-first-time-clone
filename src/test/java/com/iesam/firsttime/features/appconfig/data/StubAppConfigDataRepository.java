package com.iesam.firsttime.features.appconfig.data;

import com.iesam.firsttime.features.appconfig.domain.AppConfig;
import com.iesam.firsttime.features.appconfig.domain.AppConfigRepository;

public class StubAppConfigDataRepository implements AppConfigRepository {
    @Override
    public AppConfig getAppConfig() {
        return new AppConfig(0);
    }

    @Override
    public void saveAppConfig(AppConfig appConfig) {

    }
}
