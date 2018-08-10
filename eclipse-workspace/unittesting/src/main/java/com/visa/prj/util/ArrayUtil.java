package com.visa.prj.util;

import java.util.Arrays;

public class ArrayUtil {
	public static int getSum(int[] elems) {
		int sum = 0;
		for (Integer e : elems) {
			sum += e;
		}

		return sum;
	}

	public static int getOccurenceCount(int[] elems, int no) {
		int count = 0;
		for (Integer e : elems) {
			if (e == no)
				count++;
		}
		return count;

	}

	public static void sort(int[] elems) {
		Arrays.sort(elems);
	}
}
