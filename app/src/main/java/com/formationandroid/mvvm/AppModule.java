package com.formationandroid.mvvm;

import android.content.Context;

import com.formationandroid.mvvm.dao.ExampleDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule{

    @Singleton
    @Provides
        static ExampleDAO provideExempleDAO(ExampleDAO exampleDAO)
        {
            return exampleDAO;
        }
}
