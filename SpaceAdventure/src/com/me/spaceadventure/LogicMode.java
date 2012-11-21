package com.me.spaceadventure;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

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
		if(input.checkInput()=='W')adventurerobject.y-= 500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		else if(input.checkInput()=='S')adventurerobject.y+= 500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		else if(input.checkInput()=='D')adventurerobject.x-= 500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
		else if(input.checkInput()=='A')adventurerobject.x+= 500 * Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
	}
	public float Xpos()
	{
		System.out.println(adventurerobject.x);
		return adventurerobject.x;
	}
	public float Ypos()
	{
		return adventurerobject.y;
	}
	
}
