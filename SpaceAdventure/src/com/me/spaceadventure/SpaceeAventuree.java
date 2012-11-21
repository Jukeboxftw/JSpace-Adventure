package com.me.spaceadventure;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

public class SpaceeAventuree implements ApplicationListener {
	private LogicMode logic= new LogicMode();
	private int X=0, Y=0;
	private double origtime=TimeUtils.nanoTime();
	private Input input= new Input();
	private OrthographicCamera camera;
	private TextureRegion adventurer, background;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	@Override
	public void create() {		
		logic= new LogicMode();
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 1280, 720);
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("SpikeCity.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		adventurer = new TextureRegion(texture, 0, 0, 50, 50);
		texture = new Texture(Gdx.files.internal("gameover.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		background = new TextureRegion(texture, 0, 0, 1280, 720);
		/*sprite = new Sprite(region);
		
		//sprite.setOrigin(sprite.getWidth()*0, sprite.getHeight()*0);
		//sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		//sprite.setSize(10f, 10f * sprite.getHeight() / sprite.getWidth());
		sprite.setScale(500, 500);*/
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {
		logic.frameMove();
		Gdx.gl.glClearColor(1, 0, 1, 1);
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		input.checkInput();
		batch.begin();
		batch.draw(background, logic.Xpos(), logic.Ypos());
		batch.draw(adventurer, 1280/2, 720/3);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
