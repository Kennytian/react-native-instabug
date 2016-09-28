'use strict';

import {NativeModules} from 'react-native';

let {Instabug} = NativeModules;

module.exports = {
	reportFeedback: function () {
		Instabug.report('feedback');
	},

	reportBug: function () {
		Instabug.report('bug');
	},

	setFileAttachment: function (fileUri, fileNameWithExtension) {
		Instabug.setFileAttachment(fileUri, fileNameWithExtension);
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

	showIntroMessage: function () {
		Instabug.showIntroMessage();
	},
};
