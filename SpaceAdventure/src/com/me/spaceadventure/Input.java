package com.me.spaceadventure;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class Input {
	public Input()
	{
		
	}
	public char checkInput()
	{
		if(Gdx.input.isKeyPressed(Keys.UP)||Gdx.input.isKeyPressed(Keys.W)) 
		{
			return 'W';
			
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)||Gdx.input.isKeyPressed(Keys.S)) 
		{
			return 'S';
			
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)||Gdx.input.isKeyPressed(Keys.A)) 
		{
			return 'A';
			
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)||Gdx.input.isKeyPressed(Keys.D)) 
		{
			return 'D';
			
		}
		if(Gdx.input.isKeyPressed(Keys.SPACE)&&Gdx.input.isKeyPressed(Keys.P)!=true) 
		{
			return 'Q';
			
		}
		else return 'N';
	}

}
