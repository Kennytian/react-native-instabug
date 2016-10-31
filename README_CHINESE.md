## 摇一摇报Bug（Instabug）之 React Native 版

README: [English](https://github.com/Kennytian/react-native-instabug/) | [中文](https://github.com/Kennytian/react-native-instabug/blob/master/README_CHINESE.md)

[![Build Status](https://travis-ci.org/Kennytian/react-native-instabug.svg?branch=master)](https://travis-ci.org/Kennytian/react-native-instabug?branch=develop)
[![npm version](http://img.shields.io/npm/v/react-native-instabug.svg?style=flat-square)](https://npmjs.org/package/react-native-instabug "View this project on npm")
[![npm version](http://img.shields.io/npm/dm/react-native-instabug.svg?style=flat-square)](https://npmjs.org/package/react-native-instabug "View this project on npm")
[![js-standard-style](https://img.shields.io/badge/code%20style-standard-brightgreen.svg?style=flat)](http://standardjs.com/)
[![Github Issues](http://githubbadges.herokuapp.com/pikesley/githubbadges/issues.svg)](https://github.com/Kennytian/react-native-instabug/issues)
[![Pending Pull-Requests](http://githubbadges.herokuapp.com/pikesley/githubbadges/pulls.svg)](https://github.com/Kennytian/react-native-instabug/pulls)


[The Simplest In-App Feedback and Bug Reportng for Mobile Apps! ](https://instabug.com/developers)

![Android Demo](http://ww4.sinaimg.cn/mw690/77c29b23gw1f8hrrg0ie1j20hu0qk404.jpg)

### 安装 NPM 包

`npm install --save react-native-instabug`

### 自动安装（多数情况下能成功安装并集成到项目中）

`react-native link react-native-instabug`

### 手动安装
#### Android
编辑 android/settings.gradle，加这两行:

```diff
include ':app'

+ include ':react-native-instabug'
+ project(':react-native-instabug').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-instabug/android')
```

编辑 android/app/build.gradle，加这一行:
```diff
dependencies {
  compile fileTree(dir: "libs", include: ["*.jar"])
  compile "com.android.support:appcompat-v7:23.0.1"
  compile "com.facebook.react:react-native:+"  // From node_modules
+ compile project(':react-native-instabug')
}
```

编辑 MainApplication.java (在 android/app/src/main/java/...目录里) ，像这样，一共有两处(只支持 RN 0.29 以上版本，抱歉):
```diff
+ import com.kenny.instabug.InstabugPackage;
...
  new MainReactPackage(),
+ new InstabugPackage("your_app_token_here", MainApplication.this)
}
```

#### iOS
```diff
- 欢迎懂 iOS 的开发者加入, 和我们一起完成这个控件!
```

1. 打开 XCode, 切换至 project navigator, 右键点击 `Libraries` ➜ `Add Files to [your project's name]`
2. 进入 `node_modules` ➜ `react-native-instabug` 并且添加 `ios/RCTInstabug.xcodeproj`
3. 接着在 XCode 切换至 project navigator, 选择你的项目。 添加 `libRCTInstabug.a` 到你的项目中 ➜ `Build Phases` ➜ `Link Binary With Libraries`
4. 运行项目 (`cmd+R`)

### 调用方式

Android 端可以有大量 function 可以使用了，请戳这儿 [index.android.js](https://github.com/Kennytian/react-native-instabug/blob/master/example/index.android.js#L41)，欢迎提 PR 和 issue。

```js
_testShowIntroMessage() {
  Instabug.showIntroMessage();
}

_testInstabug() {
  Instabug.setUserEmail('your@gmail.com');
  Instabug.setUserData('This is your committed user data');
  Instabug.setUsername('Your user name');
  Instabug.addTags('react-native,bug,feedback,instabug');
  Instabug.changeInvocationEvent('Shake');
  Instabug.reportBug();
}
```

### 致谢
* @prithsharma https://github.com/prithsharma
* @emmaplus https://github.com/emmaplus
* @delfrrr https://github.com/delfrrr