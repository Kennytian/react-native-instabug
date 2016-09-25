'use strict';

import { NativeModules, Platform } from 'react-native';

let { Instabug } = NativeModules;

export function reportFeedback() {
	Instabug.report('feedback');
}

export function reportBug() {
	NativeModules.Instabug.report('bug');
}