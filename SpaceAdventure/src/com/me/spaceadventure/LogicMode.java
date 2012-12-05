package com.me.spaceadventure;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class LogicMode {
	private Array<Projectile> projectiles= new Array<Projectile>();
	private Array<Enemies> enemies = new Array<Enemies>();
	private Array<Float> ratios = new Array<Float>();
	private Iterator<Projectile> iterp = projectiles.iterator();
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
		iterr=ratios.iterator();
		moveProjectiles();
		
		if(input.checkClick())
		{
			addProjectile(adventurerobject.x, adventurerobject.y);
		}
	}
	public void addProjectile(float x, float y)
	{
		System.out.println("x"+adventurerobject.x+"mousex"+input.checkMouse());
		float xdir=0, ydir=0;
		if(input.checkMouse().x>640) xdir = input.checkMouse().x-640;
		else xdir = -1*(640 - input.checkMouse().x);
		if(input.checkMouse().y>720/2) ydir = input.checkMouse().y-720/2;
		else ydir = -1*(720/2 - input.checkMouse().y);
		Projectile bullet = new Projectile(x, y, 10, (xdir/(Math.abs(xdir)+Math.abs(ydir))), ydir/(Math.abs(xdir)+Math.abs(ydir)));
		projectiles.add(bullet);
	}
	public void addEnemy(float x, float y, char Etype)
	{
		Enemies eny = new Enemies(x,x,Etype);
		enemies.add(eny);
	}
	public void moveEnys()
	{
		
	}
	public void moveProjectiles()
	{
		while(iterp.hasNext()) 
	    {
			Projectile bullet = iterp.next();
			bullet.getNewPos();
	    }
	}
	public Array<Projectile> getProjectiles()
	{
		return projectiles;
	}
	public void sendInfo(float x,float y)
	{
		adventurerobject.x=x;
		adventurerobject.y=y;
	}
	
	
}
