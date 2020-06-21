package javaCollections.level_3.SpaceGame;

import javaCollections.level_3.SpaceGame.BaseObject;
import javaCollections.level_3.SpaceGame.weapon.Rocket;

public class SpaceShip extends BaseObject {
	private double dx;
	
	public SpaceShip(double x, double y) {
		super(x, y, 3);
	}

	public void moveLeft() {
		dx = -1;
	}
	
	public void moveRight() {
		dx = 1;
	}
	
	public void draw(Canvas canvas) {
		
	}
	
	public void move() {
		setX(getX() + dx);
		checkBorders(getX()-getRadius(), getX()+getRadius(), 0, 0);
	}
	
	public void fire() {
		Rocket r1 = new Rocket(getX()+2, getY());
		Rocket r2 = new Rocket(getX()-2, getY());
		Space.game.getRockets().add(r1);
		Space.game.getRockets().add(r2);
	}
}
