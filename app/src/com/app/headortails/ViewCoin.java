package com.app.headortails;

import java.util.Random;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class ViewCoin implements ApplicationListener {
	private Texture		inilogo;
	
	private static final int        FRAME_COLS = 5;         // #1
    private static final int        FRAME_ROWS = 5;         // #2
    // screen center.
    private int cx, cy;
    private boolean rotate;
    private boolean opening;
    private int nrep;
    Animation                       coinAnim;
    Texture                         coinSheet;
    TextureRegion[]                 coinFrames;
    SpriteBatch                     spriteBatch;
    TextureRegion                   currentFrame;

    float stateTime;
	
    
    public void create() {
    	opening = true;
    	inilogo = new Texture(Gdx.files.internal("imgs/ini_screen.png"));
		spriteBatch = new SpriteBatch();  
		stateTime = 0f;	
	}
    
    private void loadCoinAnimation() {
    	nrep = 0;
    	stateTime = 0f;	
		coinSheet = new Texture(Gdx.files.internal("imgs/hot_coin_anim.png"));
		
		TextureRegion[][] tmp = TextureRegion.split(coinSheet, coinSheet.getWidth()/FRAME_COLS, coinSheet.getHeight()/FRAME_ROWS);
		
		coinFrames = new TextureRegion[FRAME_COLS * (FRAME_ROWS - 1)];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS - 1; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                    coinFrames[index++] = tmp[i][j];
            }
		}
		rotate = false;
		cx = Gdx.graphics.getWidth() / 2;
		cy = Gdx.graphics.getHeight() / 2;
		coinAnim = new Animation(0.030f,  coinFrames);
		spriteBatch = new SpriteBatch();		
		currentFrame = coinAnim.getKeyFrame(stateTime, true);			
    }

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void pause() {
		// TODO Auto-generated method stub

	}

	public void render() {
				Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
				if (opening) {					
					spriteBatch.begin();
			        spriteBatch.draw(inilogo, 0, 0, inilogo.getWidth()/2 - Gdx.graphics.getWidth() / 2 , inilogo.getHeight()/2 - Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			        spriteBatch.end();
			        stateTime += Gdx.graphics.getDeltaTime();
			        if (stateTime > 1.0f) {
			        	this.loadCoinAnimation();				
			        	opening = false;
			        }
				} else {
				if (Gdx.input.justTouched()) {
					rotate = true;
					nrep = 10 + new Random().nextInt(20);
				}
				if (rotate) {					
					stateTime += Gdx.graphics.getDeltaTime();					
					if ((stateTime > 0.300f * nrep)) {
						if (nrep % 2 == 0)
							stateTime = 0.0f;
						else stateTime = 9.0f * 0.030f;						
						rotate = false;
					}
					currentFrame = coinAnim.getKeyFrame(stateTime, true);
				}
		        spriteBatch.begin();
		        spriteBatch.draw(currentFrame, cx - (currentFrame.getRegionWidth()/2), cy - (currentFrame.getRegionHeight()/2));
		        spriteBatch.end();
				}
	}
	
	public void startCoinRotate() {
		rotate = true;
	}
	

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	public void resume() {
		
	}

}
