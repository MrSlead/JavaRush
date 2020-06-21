package javaCollections.level_3.SpaceGame.weapon;

import javaCollections.level_3.SpaceGame.BaseObject;
import javaCollections.level_3.SpaceGame.Canvas;

public class Bomb extends BaseObject {

	public Bomb(double x, double y) {
		super(x, y, 1);
	}
	
	public void move() {
		setY(getY()+1);
	}
	
	public void draw(Canvas canvas) {
		canvas.setPoint(getX(), getY(), 'B');
	}
}
