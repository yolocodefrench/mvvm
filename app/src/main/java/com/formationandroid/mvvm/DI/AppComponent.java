package com.formationandroid.mvvm.DI;

import android.app.Application;

import com.formationandroid.mvvm.AppModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent
{
    @Component.Builder
    interface Builder
    {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }


}
