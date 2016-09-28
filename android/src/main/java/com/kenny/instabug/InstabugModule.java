package com.kenny.instabug;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.react.bridge.ReactMethod;
import com.instabug.library.Feature;
import com.instabug.library.IBGColorTheme;
import com.instabug.library.IBGInvocationEvent;
import com.instabug.library.IBGInvocationMode;
import com.instabug.library.Instabug;

public class InstabugModule extends ReactContextBaseJavaModule {
    // Reference to builder
    private Instabug.Builder mBuilder;

    private Instabug mInstabug;
    private Application mApplication;
    private String mToken;

    public InstabugModule(ReactApplicationContext reactContext, Instabug instabug) {
        super(reactContext);
        this.mInstabug = instabug;
    }

    public String getName() {
        return "Instabug";
    }

    /*@ReactMethod
    public void colorTheme(String value) {
        switch (value) {
            case "dark":
                this.mBuilder.setColorTheme(IBGColorTheme.IBGColorThemeDark);
                break;
            case "light":
                this.mBuilder.setColorTheme(IBGColorTheme.IBGColorThemeLight);
                break;
            default:
                break;
        }
    }*/


    @ReactMethod
    public void report(String value) {
        IBGInvocationMode mode = IBGInvocationMode.IBGInvocationModeNA;
        if (value.equals("bug")) {
            mode = IBGInvocationMode.IBGInvocationModeBugReporter;
        } else if (value.equals("feedback")) {
            mode = IBGInvocationMode.IBGInvocationModeFeedbackSender;
        }

        mInstabug.invoke(mode);
    }

    // default value is true
    /*@ReactMethod
    public void commentRequired(boolean value) {
        this.mBuilder.setCommentFieldRequired(value);
    }*/

    /*@ReactMethod
    public void shakingThresholdAndroid(String value) {
        if (!TextUtils.isEmpty(value)) {
            try {
                this.mBuilder.setShakingThreshold(Float.parseFloat(value + "f"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/

    /*@ReactMethod
    public void enableIntroDialog(boolean value) {
        try {
            this.mBuilder.setShouldShowIntroDialog(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    // default value is true
    /*@ReactMethod
    public void setAddLogToReports(boolean value) {
        this.mBuilder.setInstabugLogState(value ? Feature.State.ENABLED : Feature.State.DISABLED);
    }*/
}
