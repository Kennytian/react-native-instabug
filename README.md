## Instabug for React Native

#### **!!! CAN NOT WORK NOW !!!**

### Android 50% completed

#### Manually Android
Edit android/settings.gradle to look like this:

```diff
include ':app'

+ include ':react-native-instabug'
+ project(':react-native-instabug').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-instabug/android')
```

Edit android/app/build.gradle to look like this:
```diff
dependencies {
    compile fileTree(dir: "libs", include: ["*.jar"])
    compile "com.android.support:appcompat-v7:23.0.1"
    compile "com.facebook.react:react-native:+"  // From node_modules
  + compile project(':react-native-instabug')
}
```

only RN 0.29+ Edit your MainApplication.java (deep in android/app/src/main/java/...) to look like this (note two places to edit):
```diff
  new MainReactPackage(),
+ new InstabugPackage("YOUR_TOKEN_KEY", MainApplication.this)
}
```

#### Usage
```diff
+ import Instabug from 'react-native-instabug';

...

+ Instabug.shakingThresholdAndroid(0.8);
+ Instabug.colorTheme('dark');
+ Instabug.reportBug();
```

### iOS TODO
to be continued
