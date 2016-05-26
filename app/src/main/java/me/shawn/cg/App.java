package me.shawn.cg;

import android.app.Application;

import me.shawn.cg.guard.CrashReportingTree;
import timber.log.Timber;

/**
 * Created by shawn on 2016/5/26.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }
}
