package javaCollections.level_3.SpaceGame;

import java.util.Arrays;

public class Canvas {
	private int width;
	private int height;
	private char matrix [][];
	
	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;
		matrix = new char[height][width];
	}
	
	public void setPoint(double x, double y, char c) {
		if((x < 0 || y < 0) || (y >= matrix.length || x >= matrix[0].length)) {
			return;
		}
		matrix[(int) Math.round(y)][(int) Math.round(x)] = c;
	}
	
	public void drawMatrix(double x, double y, int [][] matrix, char c) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[j][i] != 0) {
					setPoint(x+j, y+i, c);
				}
			}
		}
	}
	
	public void clear() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrix[j][i] = ' ';
			}	
		}
	}
	
	public void print() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.println(matrix[j][i]);
			}	
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public char[][] getMatrix() {
		return matrix;
	}
	
	
}
