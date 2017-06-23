package com.algos.practice.hackerrank;

import java.util.Arrays;

public class Sherlock {
	
	public static void main(String[] args) {
		int [] arr = {5, 8, 14};
		System.out.println("Oveflowing on right");
		int i = Arrays.binarySearch(arr, 15);
		System.out.println("Value of i: " + i + " , binary: " + Integer.toBinaryString(i));
		System.out.println("Value of ~i: " + ~i + " , binary: " + Integer.toBinaryString(~i));
		
		i = Arrays.binarySearch(arr, 20);
		System.out.println("Value of i: " + i + " , binary: " + Integer.toBinaryString(i));
		System.out.println("Value of ~i: " + ~i + " , binary: " + Integer.toBinaryString(~i));
		
		System.out.println("In range");
		i = Arrays.binarySearch(arr, 9);
		System.out.println("Value of i: " + i + " , binary: " + Integer.toBinaryString(i));
		System.out.println("Value of ~i: " + ~i + " , binary: " + Integer.toBinaryString(~i));
		
		i = Arrays.binarySearch(arr, 7);
		System.out.println("Value of i: " + i + " , binary: " + Integer.toBinaryString(i));
		System.out.println("Value of ~i: " + ~i + " , binary: " + Integer.toBinaryString(~i));
		
		System.out.println("Oveflowing on left");
		i = Arrays.binarySearch(arr, 4);
		System.out.println("Value of i: " + i + " , binary: " + Integer.toBinaryString(i));
		System.out.println("Value of ~i: " + ~i + " , binary: " + Integer.toBinaryString(~i));
		
		i = Arrays.binarySearch(arr, 1);
		System.out.println("Value of i: " + i + " , binary: " + Integer.toBinaryString(i));
		System.out.println("Value of ~i: " + ~i + " , binary: " + Integer.toBinaryString(~i));
		
	}

}
