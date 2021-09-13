package com.dev.problema.eigthPuzzle;

public class PuzzleTeste {

	public static void main(String[] args) {
		
		int[][] initial = { {1, 8, 2}, {0, 4, 3}, {7, 6, 5} };
		int[][] goal    = { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
		
		// Coordenada de bloco branco
		int x = 1, y = 0;
		
		Puzzle puzzle = new Puzzle();
		if (puzzle.isSolvable(initial)) {
			puzzle.solve(initial, goal, x, y);
		} 
		else {
			System.out.println("A inicial fornecida é impossível de resolver");
		}
		
	}
	
}
