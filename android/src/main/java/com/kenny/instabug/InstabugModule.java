package com.kenny.instabug;

import android.net.Uri;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import com.facebook.react.bridge.ReactMethod;
import com.instabug.library.IBGInvocationMode;
import com.instabug.library.Instabug;

public class InstabugModule extends ReactContextBaseJavaModule {
    // Reference to builder
    private Instabug.Builder mBuilder;

    private Instabug mInstabug;

    public InstabugModule(ReactApplicationContext reactContext, Instabug instabug) {
        super(reactContext);
        this.mInstabug = instabug;
    }

    public String getName() {
        return "Instabug";
    }

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

    /**
     * The file at filePath will be uploaded along upcoming reports with the name fileNameWithExtension
     * @param fileUri
     * @param fileNameWithExtension
     */
    @ReactMethod
    public void setFileAttachment(String fileUri, String fileNameWithExtension){
        try{
            Uri uri = Uri.parse(fileUri);
            mInstabug.setFileAttachment(uri, fileNameWithExtension);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * If your app already acquires the user's email address and you provide it to this method,
     * Instabug will pre-fill the user email in reports.
     * @param userEmail
     */
    @ReactMethod
    public void setUserEmail(String userEmail) {
        try {
            mInstabug.setUserEmail(userEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the user name that is used in the dashboard's contacts.
     * @param username
     */
    @ReactMethod
    public void setUsername(String username) {
        try {
            mInstabug.setUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds specific user data that you need to be added to the reports
     * @param userData
     */
    @ReactMethod
    public void setUserData(String userData) {
        try {
            mInstabug.setUserData(userData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Call this method to display the discovery dialog explaining the shake gesture or the two
     * finger swipe gesture, if you've enabled it.
     * i.e: This method is automatically called on first run of the application
     */
    @ReactMethod
    public void showIntroMessage() {
        try {
            mInstabug.showIntroMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
