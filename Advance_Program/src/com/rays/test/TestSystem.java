package com.rays.test;

import java.util.ResourceBundle;

public class TestSystem {

	public static void main(String[] args) {

		ResourceBundle rc = ResourceBundle.getBundle("com.rays.bundle.system");
		
		System.out.println("url> "+rc.getString("url"));
		System.out.println("driver> "+rc.getString("driver"));
		System.out.println("password> "+rc.getString("password"));
		System.out.println("username> "+rc.getString("username"));

	}

}