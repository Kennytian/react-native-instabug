'use strict';

import {NativeModules} from 'react-native';

let {Instabug} = NativeModules;

module.exports = {
  //shakingThresholdAndroid: function (value) {
  //  Instabug.shakingThresholdAndroid(value);
  //},

  //colorTheme: function (value) {
  //  Instabug.colorTheme(value);
  //},

  reportFeedback: function () {
    Instabug.report('feedback');
  },

  reportBug: function () {
    Instabug.report('bug');
  },

  invoke: function () {
    Instabug.report('');
  },

  showIntroMessage: function () {
    Instabug.showIntroMessage();
  },

  setUserEmail: function (userEmail) {
    Instabug.setUserEmail(userEmail);
  },

  setUsername: function (username) {
    Instabug.setUsername(username);
  },

  setUserData: function (userData) {
    Instabug.setUserData(userData);
  },
};
