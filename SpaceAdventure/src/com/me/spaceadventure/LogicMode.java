package com.me.spaceadventure;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class LogicMode {
	private Array<Rectangle> projectiles= new Array<Rectangle>();
	private Array<Rectangle> projaim = new Array<Rectangle>();
	private Array<Float> ratios = new Array<Float>();
	private Iterator<Rectangle> iterp = projectiles.iterator();
	private Iterator<Rectangle> itera = projaim.iterator();
	private Iterator<Float> iterr = ratios.iterator();
	private Input input= new Input();
	private Rectangle adventurerobject = new Rectangle();
	public LogicMode()
	{
		adventurerobject = new Rectangle();
		adventurerobject.x=0;
		adventurerobject.y=0;
	}
	public void frameMove()
	{
		iterp=projectiles.iterator();
		itera=projaim.iterator();
		iterr=ratios.iterator();
		moveProjectiles();
		if(input.checkClick())
		{
			addProjectile(adventurerobject.x, adventurerobject.y);
		}
	}
	public void addProjectile(float x, float y)
	{
		System.out.println("added just 1");
		Rectangle newplat = new Rectangle(input.checkMouse().x, input.checkMouse().y, 20, 20);
		float xy=0;
		if(newplat.x>640)xy = (newplat.x-640)/(newplat.x-640+Math.abs(newplat.y-720/3));
		else xy = -(640-newplat.x)/(640-newplat.x+Math.abs(newplat.y-720/3));
		System.out.println(xy);
		ratios.add(xy);
		projaim.add(newplat);
		newplat = new Rectangle(x,y,20,20);
		projectiles.add(newplat);
	}
	public void moveProjectiles()
	{
		while(iterp.hasNext()) 
	    {
			Rectangle newplat = iterp.next();
			Rectangle newaim = itera.next();
			float ratio = iterr.next();
			if(newaim.x<newplat.x)newplat.x-=ratio*500*(Math.min(Gdx.graphics.getDeltaTime(), 1/60f));
			else newplat.x+=ratio*500*Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			if(newaim.y<newplat.y)newplat.y-=(1-ratio)*500*Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
			else  newplat.y+=(1-ratio)*500*Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
	    }
	}
	public Array<Rectangle> getProjectiles()
	{
		return projectiles;
	}
	public void sendInfo(float x,float y)
	{
		adventurerobject.x=x;
		adventurerobject.y=y;
	}
	
	
}
