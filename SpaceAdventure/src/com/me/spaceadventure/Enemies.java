package com.me.spaceadventure;

import com.badlogic.gdx.math.Rectangle;

public class Enemies 
{
	private Float Xposi,Yposi;
	private char Etypei;
	public Enemies(float Xpos,float Ypos, char Etype)
	{
		Xposi=Xpos;
		Etypei=Etype;
		Yposi=Ypos;
	}
	public Rectangle getPos()
	{
		Rectangle newplat = new Rectangle (Xposi, Yposi, 50,50);
		return newplat;
	}

}
