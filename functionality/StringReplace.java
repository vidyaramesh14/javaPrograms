package com.bridgelabz.functionality;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class StringReplace
{


		public static void main(String[] args) {

			Scanner sc1=new Scanner(System.in);
			Utility utility = new Utility();
		
			System.out.println("Please enter your name: ");
			String userName=sc1.next();
			String output = utility.replaceString( userName);
			System.out.println(output);
		}

	
}