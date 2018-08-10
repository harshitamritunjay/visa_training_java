package com.visa.prj.util;

@FunctionalInterface
public interface Compute<T> {
	void add(T x, T y);
	default void sub( T x, T y) {
		System.out.println("some code");
	}
}

