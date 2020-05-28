package com.formationandroid.mvvm;

import android.app.Application;

import com.formationandroid.mvvm.DI.AppComponent;
import com.formationandroid.mvvm.DI.DaggerAppComponent;

public class DIApplication extends Application
{
    // Attributs :
    private static DIApplication instance;
    private AppComponent appComponent;
    @Override
    public void onCreate()
    {
        // initialisation :
        super.onCreate();
        instance = this;
        // dagger :
        appComponent = DaggerAppComponent.builder().application(this).build();
    }
    // Getter singleton :
    public static AppComponent getAppComponent()
    {
        return instance.appComponent;
    }
}

