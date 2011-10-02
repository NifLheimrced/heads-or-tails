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
        
        /*
        setContentView(R.layout.main);
        
        // Create a LinearLayout in which to add the ImageView
        mLinearLayout = new LinearLayout(this);

        // Instantiate an ImageView and define its properties
        i = new ImageView(this);
        i.setOnTouchListener(new View.OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				try {
				new Thread(new Runnable() {
					AnimationDrawable fa = (AnimationDrawable) i.getBackground();
				    public void run() {				    	
				        // Start the animation (looped playback by default).
				        fa.start();	     
				    }
				  }).start();
				Thread.sleep(20*50);
				} catch (Exception ex) { }
				return true;
			}
		});
        i.setBackgroundResource(R.anim.hot_coin_rotate);
        i.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions
        i.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        
        // Add the ImageView to the layout and set the layout as the content view
        mLinearLayout.addView(i);
        setContentView(mLinearLayout);
        // Get the background, which has been compiled to an AnimationDrawable object.
 
        */
    }
}

