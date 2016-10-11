package com.kenny.instabug;

import android.net.Uri;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import com.facebook.react.bridge.ReactMethod;
import com.instabug.library.IBGInvocationEvent;
import com.instabug.library.IBGInvocationMode;
import com.instabug.library.Instabug;

import java.util.Locale;


public class InstabugModule extends ReactContextBaseJavaModule {
    private Instabug mInstabug;

    public InstabugModule(ReactApplicationContext reactContext, Instabug instabug) {
        super(reactContext);
        this.mInstabug = instabug;
    }

    public String getName() {
        return "Instabug";
    }

    //can not work
    @ReactMethod
    public void startWithToken(String token) {
        try {
            //TODO
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds tag(s) to issues before sending them
     *
     * @param tags
     */
    @ReactMethod
    public void addTags(String tags) {
        try {
            String[] result = tags.split(",");
            mInstabug.resetTags(); //clear last commit tags
            mInstabug.addTags(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Dismisses any Instabug views that are currently being shown.
     */
    @ReactMethod
    public void dismiss() {
        try {
            mInstabug.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the event used to invoke Instabug SDK
     *
     * @param eventTag
     */
    @ReactMethod
    public void changeInvocationEvent(String eventTag) {
        try {
            switch (eventTag) {
                case "TwoFingersSwipeLeft":
                    mInstabug.changeInvocationEvent(IBGInvocationEvent.IBGInvocationEventTwoFingersSwipeLeft);
                    break;
                case "FloatingButton":
                    mInstabug.changeInvocationEvent(IBGInvocationEvent.IBGInvocationEventFloatingButton);
                    break;
                case "Shake":
                    mInstabug.changeInvocationEvent(IBGInvocationEvent.IBGInvocationEventShake);
                    break;
                case "ScreenshotGesture":
                    mInstabug.changeInvocationEvent(IBGInvocationEvent.IBGInvocationScreenshotGesture);
                    break;
                case "None":
                default:
                    mInstabug.changeInvocationEvent(IBGInvocationEvent.IBGInvocationEventNone);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Change Locale of Instabug UI elements(defaults to English)
     *
     * @param languageTag
     */
    @ReactMethod
    public void changeLocale(String languageTag) {
        try {
            switch (languageTag) {
                case "CHINA":
                case "CHINESE":
                case "PRC":
                case "SIMPLIFIED_CHINESE":
                    mInstabug.changeLocale(Locale.CHINESE);
                    break;
                case "TAIWAN":
                case "TRADITIONAL_CHINESE":
                    mInstabug.changeLocale(Locale.TAIWAN);
                    break;
                case "ENGLISH":
                    mInstabug.changeLocale(Locale.ENGLISH);
                    break;
                case "UK":
                    mInstabug.changeLocale(Locale.UK);
                    break;
                case "US":
                default:
                    mInstabug.changeLocale(Locale.US);
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ReactMethod
    public void report(String value) {
        IBGInvocationMode mode;
        switch (value) {
            case "bug":
                mode = IBGInvocationMode.IBGInvocationModeBugReporter;
                break;
            case "feedback":
                mode = IBGInvocationMode.IBGInvocationModeFeedbackSender;
                break;
            default:
                mode = IBGInvocationMode.IBGInvocationModeNA;
                break;
        }

        mInstabug.invoke(mode);
    }

    /**
     * The file at filePath will be uploaded along upcoming reports with the name fileNameWithExtension
     *
     * @param fileUri
     * @param fileNameWithExtension
     */
    @ReactMethod
    public void setFileAttachment(String fileUri, String fileNameWithExtension) {
        try {
            Uri uri = Uri.parse(fileUri);
            mInstabug.setFileAttachment(uri, fileNameWithExtension);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * If your app already acquires the user's email address and you provide it to this method,
     * Instabug will pre-fill the user email in reports.
     *
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
     *
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
     *
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