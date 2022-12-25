package com.java.learning.loops;
/* give an integer ,N, print its first 10 multiples. Each multiple N*i 
 * (where 1<=i<=10) should be printed on a new line in the form:N*i=
 */

import java.util.Scanner;

public class loops {

	public static void main(String[] args) {
		System.out.println("enter an integer number");
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		for(int i=1;i<=10;i++)
		{
			int table=N*i;
			System.out.println(N+"*"+i+"="+table);
		}
		

	}

}
