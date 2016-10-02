##React Native plugin for the Instabug service

[![Build Status](https://travis-ci.org/Kennytian/react-native-instabug.svg?branch=master)](https://travis-ci.org/Kennytian/react-native-instabug)
[![npm version](http://img.shields.io/npm/v/react-native-instabug.svg?style=flat-square)](https://npmjs.org/package/react-native-instabug "View this project on npm")
[![npm version](http://img.shields.io/npm/dm/react-native-instabug.svg?style=flat-square)](https://npmjs.org/package/react-native-instabug "View this project on npm")
[![js-standard-style](https://img.shields.io/badge/code%20style-standard-brightgreen.svg?style=flat)](http://standardjs.com/)
[![Github Issues](http://githubbadges.herokuapp.com/pikesley/githubbadges/issues.svg)](https://github.com/Kennytian/react-native-instabug/issues)
[![Pending Pull-Requests](http://githubbadges.herokuapp.com/pikesley/githubbadges/pulls.svg)](https://github.com/Kennytian/react-native-instabug/pulls)


[The Simplest In-App Feedback and Bug Reportng for Mobile Apps! ](https://instabug.com/developers)

## Getting Started

`npm install --save react-native-instabug`

![Android Demo](http://ww4.sinaimg.cn/mw690/77c29b23jw1f89gh1t08dj20f40nadgt.jpg)

## Android Setup

#### Auto Link

`react-native link react-native-instabug`

#### Manually
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
+ import com.kenny.instabug.InstabugPackage;
...
  new MainReactPackage(),
+ new InstabugPackage("your_app_token_here", MainApplication.this)
}
```


## iOS TODO
to be continued


## Usage

To see all available function take a look at [index.android.js](https://github.com/Kennytian/react-native-instabug/blob/master/example/index.android.js#L41)

```js
_testShowIntroMessage(){
  Instabug.showIntroMessage();
}

_testInstabug() {
  Instabug.setUserEmail('your@gmail.com');
  Instabug.setUserData('This is your committed user data');
  Instabug.setUsername('Your user name');
  Instabug.addTags('react-native,bug,feedback,instabug');
  Instabug.reportBug();
}
```