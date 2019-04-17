package com.space_feiter;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.space_feiter.MyGdxGame;

public class AndroidLauncher extends AndroidApplication {
	ControllForAndroid controllForAndroid;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		controllForAndroid = new ControllForAndroid();
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useGL30 = false;
		config.useAccelerometer =false;
		config.useCompass = false;
		config.hideStatusBar =true;
		config.useImmersiveMode = true;

		initialize(new Main(controllForAndroid), config);

	}
}
