package com.promouit.arrays;

public class MatrixUtils {

	public static void setZeroes(int[][] matrix) {
		int[] rows = new int[matrix.length];
		int[] cols = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++)
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rows[i] == 1 || cols[j] == 1)
					matrix[i][j] = 0;
			}
		}
	}

}