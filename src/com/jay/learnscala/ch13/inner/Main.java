package com.jay.learnscala.ch13.inner;

/**
 * Created by jay on 2018/2/16.
 */
public class Main {
	private void m() {
		//        new JavaOuter().prot();
	}

	public static void main(String[] args) {
		String[] a1 = { "abc" };
		Object[] a2 = a1;
		a2[0] = new Integer(1);
	}
}
