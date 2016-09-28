'use strict';

import {NativeModules} from 'react-native';

let {InstabugModule} = NativeModules;

module.exports = {
	//shakingThresholdAndroid: function (value) {
	//	InstabugModule.shakingThresholdAndroid(value);
	//},

	//colorTheme: function (value) {
	//	InstabugModule.colorTheme(value);
	//},

	reportFeedback: function () {
		InstabugModule.report('feedback');
	},

	reportBug: function () {
		InstabugModule.report('bug');
	}
};