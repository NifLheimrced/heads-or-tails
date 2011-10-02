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
	
	
	private static final int        FRAME_COLS = 5;         // #1
    private static final int        FRAME_ROWS = 5;         // #2
    // screen center.
    private int cx, cy;
    private boolean rotate;
    private int nrep;
    Animation                       coinAnim;          // #3
    Texture                         coinSheet;              // #4
    TextureRegion[]                 coinFrames;             // #5
    SpriteBatch                     spriteBatch;            // #6
    TextureRegion                   currentFrame;           // #7

    float stateTime;
	
    
    public void create() {
    	nrep = 0;
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
		stateTime = 0f;		
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void pause() {
		// TODO Auto-generated method stub

	}

	public void render() {
				Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
				
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
	
	public void startCoinRotate() {
		rotate = true;
	}
	

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	public void resume() {
		
	}

}
