package com.kenny.instabug;

import android.app.Application;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.instabug.library.IBGColorTheme;
import com.instabug.library.IBGInvocationEvent;
import com.instabug.library.Instabug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InstabugPackage implements ReactPackage {
    private String mToken;
    private Application mApplication;

    private Instabug mInstagbug;
    private Instabug.Builder mBuilder;

    public InstabugPackage(Instabug instabug) {
        this.mInstagbug = instabug;
    }

    public InstabugPackage(Instabug.Builder builder) {
        this.mBuilder = builder;
    }

    public InstabugPackage(String token, Application application) {
        this.mToken = token;
        this.mApplication = application;

        mInstagbug = new Instabug.Builder(mApplication, mToken)
                .setDebugEnabled(true)
                .setEmailFieldRequired(false)
                .setFloatingButtonOffsetFromTop(400)
                .setColorTheme(IBGColorTheme.IBGColorThemeLight)
                .setShouldShowIntroDialog(false)
                .setInvocationEvent(IBGInvocationEvent.IBGInvocationEventShake)
                //.setDefaultInvocationMode(IBGInvocationMode.IBGInvocationModeBugReporter)
                .build();

    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<NativeModule>();
        //modules.add(new InstabugModule(reactContext, this.mToken, this.mApplication));
        //modules.add(new InstabugModule(reactContext, this.mBuilder));
        modules.add(new InstabugModule(reactContext, this.mInstagbug));
        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}