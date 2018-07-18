package com.udemy.demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		readXLS();
	}
		
	public static void readCSV() {
		
		String filename = "/Users/dfinies/hello/UserAccounts.csv";
		List <String[]> records = com.udemy.utilities.CSV.get(filename);
		
		//Iterating through the list
		for (String[] record : records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	
	public static void readXLS() {
		
		String filename = "/Users/dfinies/hello/UserLogin.xls";
		String[][] data = com.udemy.utilities.Excel.get(filename);
		for (String[] record : data) {
			System.out.println("\nNew Record");
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
		
	}

}
