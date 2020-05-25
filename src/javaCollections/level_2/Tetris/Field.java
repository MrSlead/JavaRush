package javaCollections.level_2.Tetris;

public class Field {
	private int width;
	private int height;
	private int matrix [][];
	
	public Field(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.matrix = new int[height][width];
	}
	
	public void print() {
		
	}
	
	public Integer getValue(int x, int y) {
		return matrix[y][x];
		
	}
	
	public void setValue(int x, int y, int value) {
		matrix[y][x] = value;
	}
	
	public void removeFullLines() {
		
	}
	

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[][] getMatrix() {
		return matrix;
	}
}
