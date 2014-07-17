package com.djun100.demodialog;

import de.akquinet.android.androlog.Log;


public class Logger {

	public static void log(String log){
		if (null != log)
			Log.d("UMS", log);
	}
}
