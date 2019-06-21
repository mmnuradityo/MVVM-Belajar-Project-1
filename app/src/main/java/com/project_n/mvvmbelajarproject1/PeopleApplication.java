package com.project_n.mvvmbelajarproject1;

import android.content.Context;

import com.project_n.mvvmbelajarproject1.data.PeopleFactory;
import com.project_n.mvvmbelajarproject1.data.PeopleService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class PeopleApplication extends MultiDexApplication {

    private PeopleService peopleService;
    private Scheduler scheduler;

    private static Context get(Context context) {
        return context.getApplicationContext();
    }

    public static Context create(Context context) {
        return PeopleApplication.get(context);
    }

    public PeopleService getPeopleService() {
        if (peopleService == null) {
            peopleService = PeopleFactory.create();
        }
        return peopleService;
    }

    public Scheduler subscribeShedler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }
        return  scheduler;
    }
    
}
