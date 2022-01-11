package com.ccsprite.game;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;


public class AndroidLauncher extends AndroidApplication {


	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new ClickClack(), config);
	}
/*
	@Override
	public void onBackPressed() {


		if (ekran == 1) {

			if (EnumClass.state == EnumClass.State.RUN) {
				EnumClass.state = EnumClass.State.PAUSE;

			} else {
				EnumClass.state = EnumClass.State.RUN;
			}

		}
		if(ekran == 2){




		}
		if(ekran == 3){}
		if(ekran == 4){}
		if(ekran == 5){}
		if(ekran == 6){}



	}
	*/
}
