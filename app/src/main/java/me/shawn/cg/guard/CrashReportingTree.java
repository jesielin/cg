package me.shawn.cg.guard;

import java.util.Timer;

import timber.log.Timber;

/**
 * Created by shawn on 2016/5/26.
 */
public class CrashReportingTree extends Timber.Tree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {

    }
}
