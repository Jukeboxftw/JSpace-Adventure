package com.me.spaceadventure;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class LogicMode {
	private Input input= new Input();
	private Rectangle adventurerobject;
	public LogicMode()
	{
		adventurerobject = new Rectangle();
		adventurerobject.x=0;
		adventurerobject.y=0;
	}
	public void frameMove()
	{
		if(input.checkDirectionInput()=='E')
		{
			adventurerobject.y-= 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			adventurerobject.x-= 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		else if(input.checkDirectionInput()=='Q')
		{
			adventurerobject.y-= 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			adventurerobject.x+= 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		else if(input.checkDirectionInput()=='C')
		{
			adventurerobject.y+= 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			adventurerobject.x-= 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		else if(input.checkDirectionInput()=='Z')
		{
			adventurerobject.y+= 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			adventurerobject.x+= 353 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		}
		else if(input.checkDirectionInput()=='W')adventurerobject.y-= 500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		else if(input.checkDirectionInput()=='S')adventurerobject.y+= 500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		else if(input.checkDirectionInput()=='D')adventurerobject.x-= 500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		else if(input.checkDirectionInput()=='A')adventurerobject.x+= 500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
	}
	public float Xpos()
	{
		return adventurerobject.x;
	}
	public float Ypos()
	{
		return adventurerobject.y;
	}
	public Vector3 getMouse()
	{
		Vector3 touchPos = new Vector3();
		if(input.checkMouse()!=null) touchPos = input.checkMouse();
		return touchPos;

	}
	
}
