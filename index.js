'use strict';

import {NativeModules} from 'react-native';

let {Instabug} = NativeModules;

module.exports = {
	//shakingThresholdAndroid: function (value) {
	//	Instabug.shakingThresholdAndroid(value);
	//},

	//colorTheme: function (value) {
	//	Instabug.colorTheme(value);
	//},

	reportFeedback: function () {
		Instabug.report('feedback');
	},

	reportBug: function () {
		Instabug.report('bug');
	}
};