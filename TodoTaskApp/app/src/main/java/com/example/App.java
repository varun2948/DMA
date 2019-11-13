package com.example;

import android.app.Application;

import com.evernote.android.job.JobManager;
import com.example.todotaskapp.notification.NotificationJob;
import com.example.todotaskapp.notification.NotificationJobCreator;

public class App extends Application {
    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        registerJobManager();
        app = this;
    }

    private void registerJobManager() {
        JobManager.create(this).addJobCreator(new NotificationJobCreator());
        NotificationJob.schedule();
        NotificationJob.runNow();
    }

    public static App getInstance() {
        return app;
    }
}
