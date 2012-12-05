package com.me.spaceadventure;


import java.util.Iterator;

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
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

public class SpaceeAventuree implements ApplicationListener {
	private Input input = new Input();
	private LogicMode logic= new LogicMode();
	private Iterator<Projectile> iterp;
	private double origtime=TimeUtils.nanoTime();
	private OrthographicCamera camera;
	private Rectangle player, cursor;
	private TextureRegion adventurer, background;
	private SpriteBatch batch;
	private Texture texture, crosshair, enemy;
	private Sprite sprite;
	
	@Override
	public void create() {		
		logic= new LogicMode();
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 1280, 720);
	    camera.position.set(640f,360f, 0);
		batch = new SpriteBatch();
		enemy = new Texture(Gdx.files.internal("SpikeRainbow.png"));
		enemy.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		texture = new Texture(Gdx.files.internal("SpikeCity.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		adventurer = new TextureRegion(texture, 0, 0, 50, 50);
		texture = new Texture(Gdx.files.internal("gameover.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		background = new TextureRegion(texture, 0, 0, 1280, 720);
		crosshair = new Texture(Gdx.files.internal("crosshair.png"));
		crosshair.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		player = new Rectangle(1280/2,720/2, 50, 50);
		cursor = new Rectangle(input.checkMouse().x, input.checkMouse().y, 20,20);
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
		handleInput();
		logic.sendInfo(player.x, 720-player.y);
		cursor.x=input.checkMouse().x+player.x-1280/2;
		cursor.y=720-input.checkMouse().y+player.y-720/2;
		Gdx.gl.glClearColor(1, 0, 1, 1);
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.draw(adventurer, player.x, player.y);
		batch.draw(crosshair, (cursor.x -10),(cursor.y -10 ));
		iterp= logic.getProjectiles().iterator();
		while(iterp.hasNext())
		{
			Projectile newplat = iterp.next();
			batch.draw(crosshair, newplat.getPos().x, 720-newplat.getPos().y);
		}
		batch.end();
	}
	public void handleInput()
	{
		if(input.checkDirectionInput()=='E'&&player.y+10<=background.getRegionHeight()&&player.x+10<=background.getRegionWidth())
		{
			camera.translate(353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f), 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f));
			player.x+=353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			player.y+=353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		if(input.checkDirectionInput()=='Q'&&player.x-10>=background.getRegionX()&&player.y+10<=background.getRegionHeight())
		{
			camera.translate(-353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f), 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f));
			player.x-=353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			player.y+=353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		if(input.checkDirectionInput()=='C'&&player.x+10<=background.getRegionWidth()&&player.y-10>=background.getRegionY())
		{
			camera.translate(353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f), -353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f));
			player.x+=353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			player.y-=353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		if(input.checkDirectionInput()=='Z'&&player.x-10>=background.getRegionX()&&player.y-10>=background.getRegionY())
		{
			camera.translate(-353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f), -353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f));
			player.x-=353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			player.y-=353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		if(input.checkDirectionInput()=='W'&&player.y+10<=background.getRegionHeight())
		{
			camera.translate(0, 500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f));
			player.y+=500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		if(input.checkDirectionInput()=='S'&&player.y-10>=background.getRegionX())
		{
			camera.translate(0, -500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f));
			player.y-=500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		if(input.checkDirectionInput()=='A'&&player.x-10>=background.getRegionX())
		{
			camera.translate(-500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f), 0);
			player.x-=500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		if(input.checkDirectionInput()=='D'&&player.x+10<=background.getRegionWidth())
		{
			camera.translate(500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f), 0);
			player.x+=500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		logic.sendInfo(player.x, player.y);
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
