package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data= {4,5,1,10};
		int expected=20;
		assertEquals(expected,ArrayUtil.getSum(data));
		
		int[] values={-1,0,1};
		expected=0;
		assertEquals(expected,ArrayUtil.getSum(values));
	}
	

	@Test
	public void testGetOccurenceCount() {
		int[] data= {5,2,6,5,1,7,9,5};
		int expected=3;
		assertEquals(expected, ArrayUtil.getOccurenceCount(data, 5));
		
	}

	@Test
	public void testSort() {
		int[] data= {4,5,1,10};
		int[] expected= {1,4,5,10};
		ArrayUtil.sort(data);
		//if I use assertEquals then addresses will be compared (in case of primitives)
		//hence here we use assertArrayEquals for Array element comparison
		assertArrayEquals(expected,data);
	}

}
