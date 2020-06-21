package javaCollections.level_3.SpaceGame;

import javaCollections.level_3.SpaceGame.BaseObject;
import javaCollections.level_3.SpaceGame.weapon.Bomb;

public class Ufo extends BaseObject {
	  private static int[][] matrix = {                                                  
	            {0, 0, 0, 0, 0},                                                  
	            {0, 0, 1, 0, 0},                                                  
	            {0, 0, 1, 0, 0},                                                  
	            {1, 0, 1, 0, 1},                                                  
	            {1, 1, 1, 1, 1},                                                  
	    };
	  
	public Ufo(double x, double y) {
		super(x, y, 3);
	}
	
	@Override                                                  
    public void draw(Canvas canvas) {                                                  
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');                                                  
    }         
	
	public void move() {
		double dx = Math.random()*2-1;
		double dy = Math.random()*2-1;
		if(Math.random()*9 == 0) {
			fire();
		}
	}
                                                 
	public void fire() {                                                  
        Space.game.getBombs().add(new Bomb(x, y));                                                                                                   
    }  
}
