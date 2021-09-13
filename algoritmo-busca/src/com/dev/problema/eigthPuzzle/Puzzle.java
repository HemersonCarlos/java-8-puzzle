package com.dev.problema.eigthPuzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Puzzle {

public int dimension = 3;
	
	// Baixo, Esquerda, Cima, Direita
	int[] row = { 1, 0, -1, 0 };
	int[] col = { 0, -1, 0, 1 };
	
	public int calculateCost(int[][] initial, int[][] goal) {
		int count = 0;
		int n = initial.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (initial[i][j] != 0 && initial[i][j] != goal[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean isSafe(int x, int y) {
		return (x >= 0 && x < dimension && y >= 0 && y < dimension);
	}
	
	public void printPath(No root) {
		if (root == null) {
			return;
		}
		printPath(root.parente);
		printMatrix(root.matrix);
		System.out.println();
	}
	
	public boolean isSolvable(int[][] matrix) {
		int count = 0;
		List<Integer> array = new ArrayList<Integer>();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				array.add(matrix[i][j]);
			}
		}
		
		Integer[] anotherArray = new Integer[array.size()];
		array.toArray(anotherArray);
		
		for (int i = 0; i < anotherArray.length - 1; i++) {
			for (int j = i + 1; j < anotherArray.length; j++) {
				if (anotherArray[i] != 0 && anotherArray[j] != 0 && anotherArray[i] > anotherArray[j]) {
					count++;
				}
			}
		}
		
		return count % 2 == 0;
	}
	
	public void solve(int[][] initial, int[][] goal, int x, int y) {
		PriorityQueue<No> pq = new PriorityQueue<No>(1000, (a, b) -> (a.cost + a.level) - (b.cost + b.level));
		No root = new No(initial, x, y, x, y, 0, null);
		root.cost = calculateCost(initial, goal);
		pq.add(root);
		
		while (!pq.isEmpty()) {
			No min = pq.poll();
			if (min.cost == 0) {
				printPath(min);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
	            if (isSafe(min.x + row[i], min.y + col[i])) {
	            	No child = new No(min.matrix, min.x, min.y, min.x + row[i], min.y + col[i], min.level + 1, min);
	            	child.cost = calculateCost(child.matrix, goal);
	            	pq.add(child);
	            }
	        }
		}
	}
	
}
