package javaCollections.level_3.SpaceGame;

import javaCollections.level_3.SpaceGame.weapon.Bomb;
import javaCollections.level_3.SpaceGame.weapon.Rocket;

import java.util.ArrayList;
import java.util.List;


public class Space {
	public static Space game;
	private int width;
	private int height;
	private SpaceShip ship;
	
	private List<Ufo> ufos = new ArrayList<>();
	private List<Rocket> rockets = new ArrayList<>();;
	private List<Bomb> bombs = new ArrayList<>();;
	
	public Space(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public static void main(String[] args) {
	}
	
	public void draw() {
		
	}
	
	public void run() {
		
	}
	
	public void sleep(int ms) {
		
	}

	public SpaceShip getShip() {
		return ship;
	}

	public void setShip(SpaceShip ship) {
		this.ship = ship;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<Ufo> getUfos() {
		return ufos;
	}

	public List<Rocket> getRockets() {
		return rockets;
	}

	public List<Bomb> getBombs() {
		return bombs;
	}
}
