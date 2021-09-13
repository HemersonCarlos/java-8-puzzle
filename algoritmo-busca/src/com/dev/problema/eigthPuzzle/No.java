package com.dev.problema.eigthPuzzle;

public class No {

	public No parente;
	public int[][] matrix;
	
	public int x, y;
	
	public int cost;
	
	public int level;
	
	public No(int[][] matrix, int x, int y, int newX, int newY, int level, No parente) {
		this.parente = parente;
		this.matrix = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			this.matrix[i] = matrix[i].clone();
		}
		
		// Valor de troca
		this.matrix[x][y]       = this.matrix[x][y] + this.matrix[newX][newY];
		this.matrix[newX][newY] = this.matrix[x][y] - this.matrix[newX][newY];
		this.matrix[x][y]       = this.matrix[x][y] - this.matrix[newX][newY];
		
		this.cost = Integer.MAX_VALUE;
		this.level = level;
		this.x = newX;
		this.y = newY;
	}
	
}