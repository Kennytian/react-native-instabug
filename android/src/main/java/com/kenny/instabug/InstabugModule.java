package com.kenny.instabug;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import android.app.Application;
import android.text.TextUtils;

import com.facebook.react.bridge.ReactMethod;
import com.instabug.library.Feature;
import com.instabug.library.IBGColorTheme;
import com.instabug.library.IBGInvocationMode;
import com.instabug.library.Instabug;

public class InstabugModule extends ReactContextBaseJavaModule {

    private final static String TAG = InstabugModule.class.getSimpleName();

    private String mToken;
    private Application mApplication;

    // Reference to builder
    private Instabug.Builder mBuilder;

    public InstabugModule(ReactApplicationContext reactContext, String token, Application application) {
        super(reactContext);
        this.mToken = token;
        this.mApplication = application;
        this.mBuilder = new Instabug.Builder(this.mApplication, this.mToken);
    }

    public String getName() {
        return TAG;
    }

    // default value is true
    @ReactMethod
    public void commentRequired(boolean value) {
        this.mBuilder.setCommentFieldRequired(value);
    }

    // default theme is light
    @ReactMethod
    public void colorTheme(String value) {
        switch (value) {
            case "light":
                this.mBuilder.setColorTheme(IBGColorTheme.IBGColorThemeLight);
                break;
            case "dark":
                this.mBuilder.setColorTheme(IBGColorTheme.IBGColorThemeDark);
                break;
            default:
                break;
        }
    }

    @ReactMethod
    public void shakingThresholdAndroid(String value) {
        if (!TextUtils.isEmpty(value)) {
            try {
                this.mBuilder.setShakingThreshold(Float.parseFloat(value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @ReactMethod
    public void enableIntroDialog(boolean value) {
        try {
            this.mBuilder.setShouldShowIntroDialog(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void report(String value) {
        Log.d(TAG, value);
        switch (value) {
            case "bug":
                this.mBuilder.setDefaultInvocationMode(IBGInvocationMode.IBGInvocationModeBugReporter);
                break;
            case "feedback":
                this.mBuilder.setDefaultInvocationMode(IBGInvocationMode.IBGInvocationModeFeedbackSender);
                break;
            default:
                this.mBuilder.setDefaultInvocationMode(IBGInvocationMode.IBGInvocationModeNA);
                break;
        }
        this.mBuilder.build();
    }

    // default value is true
    @ReactMethod
    public void setAddLogToReports(boolean value) {
        this.mBuilder.setInstabugLogState(value ? Feature.State.ENABLED : Feature.State.DISABLED);
    }
}
