package com.sanju784.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	TextureAtlas shooterAtlas;
	Animation animation;
	float timePassed = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		shooterAtlas = new TextureAtlas(Gdx.files.internal("shooter.atlas"));
		animation = new Animation(1/3f, shooterAtlas.getRegions());

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		timePassed += Gdx.graphics.getDeltaTime();
		batch.draw((TextureRegion) animation.getKeyFrame(timePassed, true), 300, 500);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shooterAtlas.dispose();
	}
}
