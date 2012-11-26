package com.me.spaceadventure;

import com.badlogic.gdx.math.Rectangle;

public class Projectile 
{
	private float Xpos, Ypos, Speed, Xsped, Ysped;
	public Projectile(float xpos, float ypos, float speed, float xsped, float ysped)
	{
		Xpos=xpos;
		Ypos=ypos;
		Speed=speed;
		Xsped=xsped;
		Ysped=ysped;
	}
	public void getNewPos()
	{
		Xpos+=Xsped*Speed;
		Ypos+=Ysped*Speed;
	}
	public Rectangle getPos()
	{
		Rectangle newplat = new Rectangle(Xpos, Ypos, 20, 20);
		return newplat;
	}

}
