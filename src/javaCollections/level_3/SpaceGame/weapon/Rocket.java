package javaCollections.level_3.SpaceGame.weapon;

import javaCollections.level_3.SpaceGame.BaseObject;
import javaCollections.level_3.SpaceGame.Canvas;

public class Rocket extends BaseObject {

	public Rocket(double x, double y) {
		super(x, y, 1);
	}
	
	public void move() {
		setY(getY()-1);
	}
	
	public void draw(Canvas canvas) {
		canvas.setPoint(getX(), getY(), 'R');
	}
}