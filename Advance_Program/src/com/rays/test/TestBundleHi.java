package com.rays.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestBundleHi {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("hi"));

		System.out.println(rb.getString("greeting"));

	}

}
