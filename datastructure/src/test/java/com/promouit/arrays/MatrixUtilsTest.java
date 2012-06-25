package com.promouit.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixUtilsTest {

	@Test
	public void shouldSetZeros() {
		int[][] matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 0, 14, 15 }, { 16, 17, 18, 19, 20 } };
		MatrixUtils.setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			assertTrue(matrix[i][2] == 0);
		}
		for (int i = 0; i < matrix[2].length; i++) {
			assertTrue(matrix[2][i] == 0);
		}
	}

}