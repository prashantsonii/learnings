package com.elmejor.miscellaneous;
/*
 * Given an unsorted array of integers, assume the elements are inserted into BST. 
 * Search for an element and print the path if found. 
 * If the element is left of previous in BST then path variable is 1 else 0. 
 * Eg:Input: Given array[] = {8, 2, 4, 9, 12, 3, 1} 
 *  8
   / \
  2   9
 / \   \
1   4   12
   /
  3
  Search key = 3 should print “101”,  key = 11 shouldn’t print any.
 */
public class PathFinder {
	
	private static char leftDir = '1';
	private static char rightDir = '0';
	
	private static int index = 0;
	
	public static String findPathInArray(int[] arr, int num) {
		index = 0;
		int root = arr[0];
		String path = "";

		while(index < arr.length && root != num) {
			char dir;
			if (num < root) {
				dir = leftDir;
			} else {
				dir = rightDir;
			}
			path += dir;
			root = findNextRoot(arr, root, dir);
		}
		if (index == arr.length) {
			return "";
		}
		return path;
	}

	private static int findNextRoot(int[] arr, int root, char dir) {
		int newRoot = -1;
		while (++index < arr.length) {
			if(dir == leftDir && arr[index] < root) {
				newRoot = arr[index];
				break;
			} else if(dir == rightDir && arr[index] > root) {
				newRoot = arr[index];
				break;
			}
		}
		return newRoot;
	}
}
