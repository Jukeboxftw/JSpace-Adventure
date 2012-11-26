package com.me.spaceadventure;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;

public class Input {
	public Input()
	{
		
	}
	public char checkDirectionInput()
	{
		if((Gdx.input.isKeyPressed(Keys.UP)||Gdx.input.isKeyPressed(Keys.W))&&(Gdx.input.isKeyPressed(Keys.RIGHT)||Gdx.input.isKeyPressed(Keys.D))) return 'E';
		if((Gdx.input.isKeyPressed(Keys.UP)||Gdx.input.isKeyPressed(Keys.W))&&(Gdx.input.isKeyPressed(Keys.LEFT)||Gdx.input.isKeyPressed(Keys.A))) return 'Q';
		if((Gdx.input.isKeyPressed(Keys.DOWN)||Gdx.input.isKeyPressed(Keys.S))&&(Gdx.input.isKeyPressed(Keys.RIGHT)||Gdx.input.isKeyPressed(Keys.D))) return 'C';
		if((Gdx.input.isKeyPressed(Keys.DOWN)||Gdx.input.isKeyPressed(Keys.S))&&(Gdx.input.isKeyPressed(Keys.LEFT)||Gdx.input.isKeyPressed(Keys.A))) return 'Z';
		if(Gdx.input.isKeyPressed(Keys.UP)||Gdx.input.isKeyPressed(Keys.W)) return 'W';
		if(Gdx.input.isKeyPressed(Keys.DOWN)||Gdx.input.isKeyPressed(Keys.S)) return 'S';
		if(Gdx.input.isKeyPressed(Keys.LEFT)||Gdx.input.isKeyPressed(Keys.A)) return 'A';
		if(Gdx.input.isKeyPressed(Keys.RIGHT)||Gdx.input.isKeyPressed(Keys.D)) return 'D';
		if(Gdx.input.isKeyPressed(Keys.SPACE)||Gdx.input.isKeyPressed(Keys.P)!=true) return 'O';
		else return 'N';
	}
	public Vector3 checkMouse()
	{
	         Vector3 touchPos = new Vector3();
	         touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
	         return touchPos;
	}
	public boolean checkClick()
	{
		if(Gdx.input.justTouched())
		{
			return true;
		}
		return false;
	}

}
