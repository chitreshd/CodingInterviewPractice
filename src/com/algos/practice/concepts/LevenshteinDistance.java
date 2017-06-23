package com.algos.practice.concepts;

public class LevenshteinDistance {
	
	public static int levDistance(int i, int j, char []a, char [] b) {
		
		if(i == 0)
			return j;
		
		if (j == 0)
			return i;
		
		int deletion = levDistance(i - 1, j, a, b) + 1;
		int insertion = levDistance(i, j - 1, a, b) + 1;
		
		int matchResult = a[i - 1] == b[j - 1] ? 0 : 1;
		int update = levDistance(i - 1, j - 1, a, b) + matchResult;
		
		int minIJ = Math.min(update, Math.min(insertion, deletion));
		
		return minIJ;
		
	}
	
	public static void main(String[] args) {
		
		runner("ab", "ac");
		runner("ab", "def");
		runner("a", "an");
		runner("snowy", "sunny");
		
	}

	private static void runner(String str1, String str2) {
		int minDistance = levDistance(str1.length(), str2.length(), str1.toCharArray(), str2.toCharArray());
		System.out.println(String.format("Min distance from %s to %s : %d", str1, str2, minDistance));
	}

}

