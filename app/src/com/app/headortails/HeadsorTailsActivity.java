package com.app.headortails;

import android.os.Bundle;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.backends.android.AndroidApplication;

public class HeadsorTailsActivity extends AndroidApplication {
	
	private ViewCoin vc;
	
	public class TouchEventHandler implements InputProcessor {

		public boolean keyDown(int arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean keyTyped(char arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean keyUp(int arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean scrolled(int arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
			vc.startCoinRotate();
			return true;
		}

		public boolean touchDragged(int arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean touchMoved(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        vc = new ViewCoin();
        initialize(vc, false);
      
    }
}

