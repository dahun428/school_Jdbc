package com.sample.school.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardUtil {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static String nextString() throws IOException {
		String text = reader.readLine();
		return text;
	}
	public static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextString());
		
	}
	public static long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextString());
	}
	public static double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextString());
	}
	public static void close() throws IOException{
		reader.close();
	}
	
	
}
