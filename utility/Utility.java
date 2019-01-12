package com.bridgelabz.utility;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utility 
{
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * This method takes an input string from the user and returns
	 * it to the specified method. 
	 * 
	 * @return String: the input string given by the user
	 */
	public String inputString() {
		return scanner.next();
	}
	
	public String inputStringWithNext() {
		return scanner.nextLine();
	}
	/**
	 * This method takes an input string from the user and returns
	 * it to the specified method. 
	 * 
	 * @return String: the input string given by the user
	 */
	public Integer inputInteger() {
		return scanner.nextInt();
	}
	
	public Double inputDouble() {
		// TODO Auto-generated method stub
		return scanner.nextDouble();
	}

/************************String Replace **************************/
	/**
	 * This method replaces the template with the given input string
	 * 
	 * @param template is a string which is to be modified or replace
	 * @param userName the input string given by the user
	 * @return output the modified string
	 */
	public String replaceString(String template, String userName) {
		if (userName.length() < 3)
			return "Please input name with more than 3 characters";
		else {
			String output = template.replace("<<UserName>>", userName);
			return output;
		}
	}
/****************************Flip Coin******************************/
	
	static Random random = new Random(); //Random function to
	//to generate random numbers

	/**This method generate random numbers and check whether 
	* it is head or tail
	* @param no_of_times is the range..and till that range
	* you have to generate random numbers.
	*/
	public void HeadOrTail( int no_of_times)
	{
		long headpercentage=0 , tailpercentage=0;
		int headcount=0 , tailcount=0;
		//recursion method to enter valid input
		if(no_of_times<0)
		{
				System.out.println("Please enter valid input :");
				no_of_times=scanner.nextInt();
				HeadOrTail(no_of_times);
		}
		for(int i=0;i<no_of_times;i++)
		{
			double	randNumber = Math.random();
			System.out.println("Random numbers are\t :"+randNumber);
			if(randNumber<0.5)
			{
				System.out.println("****Tail****\t\t :"+randNumber+"\n");
				tailcount=tailcount+1;
			}
			else
			{
				System.out.println("****Head****\t\t :"+randNumber+"\n");
				headcount=headcount+1;
			}
		}
		System.out.println("Total heads are :"+headcount);
		System.out.println("Total tails are :"+tailcount);
		
		headpercentage = (headcount*100)/no_of_times;
		System.out.println("Percetage of occurence of head is :"+headpercentage);
		tailpercentage = (tailcount*100)/no_of_times;
		System.out.println("Percetage of occurence of tail is :"+tailpercentage);
		if(headpercentage>tailpercentage)
		{
			System.out.println("\n Head count is greater");
		}
		else
			System.out.println("Tail count is greater ");
		}
/*************************Leap Year ***************************/

	int n;

	/**This method check that entered year is leap 
	 * year or not
	 */
	public void leap_year(int yearnumber)
	{
		if(String.valueOf(yearnumber).length()<4)
		{
			System.out.println("Please enter 4 digit number :");
			yearnumber=scanner.nextInt();
			leap_year(yearnumber);
		}
		
		else if(yearnumber%4==0)
		{
			//if yr no. is divisible by 4 then check by 100
			if(yearnumber%100==0)
			{
				//now checking no. is divisible by 400 or not
				if(yearnumber%400==0)
				{
					//if no. divisible by 4,100 and 400 ie. leap year
					System.out.println("\nIt is leap year");
				}
				else
					System.out.println("\\nIt is not  leap year ");
			}
			//if no is divisible by 4 and not by 100 ,that is leap yr
			else
				System.out.println("\nIt is leap year");
		}
		else
			System.out.println("\nIt is not leap year ");
	}
	
/***********************Power Of 2*****************************/
	
	/**This method Print the table of two till the range 
	 * entered by user* 
	 */
	public void table(int n)
	{  	
		int i = 1,mul;
		if(n<=31)
		{
			for(i=0;i<=n;i++)
			{     
			  	mul=(int) Math.pow(2,i);
		      	System.out.printf("\n%d",mul);
			}
		}
		else
			System.out.println("Invalid input..!!!");			
	}
	
/***********************Harmonic Number**********************/
	/**
	 * @param n is the limit, taken from user
	 * @return It return output
	 */
	public int sum(int n)
	{
		float sum=0;
		
		//ensure n!=0
	    if(n>0)
	    {
			for(int i=1;i<=n;i++)
			{
				sum=sum+(float)1/i;
				
			}
			System.out.println("\nSum of harmonic no :"+sum);
	    }
	    else
	    	System.out.println("You have entered invalid no.");
		return n;
	}
	
/****************************Factors****************************/
	/**This method calculate factors of prime no.
	 * @param n is a input given by user
	 * whose factors we have to calculate
	 */
	public void calculate(int n)
	{
		System.out.print("The prime factorization of " + n + " is: ");
        for (int i = 2; i*i <= n; i++) 
        {
            while (n % i == 0) 
            {
                System.out.print(i + " "); 
                n = n / i;
            }
        }
        if (n > 1)
        	System.out.println(n);
        else     
        	System.out.println();
	}
/*****************************Gambler****************************/
	
	/**This method shows simulation of gambler game that how 
	 * and when game the game will win  
	 * @param n is range that how many times you are going to play
	 * @param stake is your initial amount 
	 * @param goal is achieve goal that is increment in amount
	 * @param bets is counter to check whether how many times 
	 * you can play
	 * @param win is counter that how many times you win 
	 */
	public void playthegame(int n , int stake , int goal )
	{ int win=0,loose=0;
		for(int i=0;i<n;i++)
		{
			    int cash = stake;
	            while (cash > 0 && cash < goal) //play till cash is greater 
	            {								//than 0 and less than goal 
	                
	                if (Math.random() < 0.5)
	                	cash++;     // win $1
	                else
	                	cash--;     // lose $1
	            }
	            if (cash == goal) 
	            	win++;  
	            else
	            	loose++;
	            	
	    }
		System.out.println("\nHe/She wins "+win+" of "+ n);
		System.out.println("\nPercentage of win is : "+100*win/n);	
		System.out.println("\nPercentage of loose is : "+100*win/n);
	}
/***************************Coupon Number ********************/
	/**This method generate random numbers and repeatedly
	 * check whether it is unique one or not 
	 * @param No_Of_Times is the number thats how many coupons 
	 * you wants to generate
	 * @return one temporary variable which is used for 
	 * looping
	 */
	
	public static double RandomNumberGeneration(int No_Of_Times)
	{
		boolean[] isDistinct = new boolean[No_Of_Times];
		int temp=0;
		while(temp<No_Of_Times)
		{	
			int randomnumber = (int ) (Math.random()*No_Of_Times);
			if(!isDistinct[randomnumber])
			{
				temp++;
				isDistinct[randomnumber]=true;
				System.out.println("Distinct coupons are : "+randomnumber);
			}
		}
		return temp;
	}
/**************************2D Array*****************************/		
	
	PrintWriter printwriter = new PrintWriter(System.out, true);
	/**This method generate two dimensional array and print using 
	 * printWriter function
	 * @param M this parameter is for entering number 
	 * 			of rows
	 * @param N this parameter is for entering number
	 * 			of columns 
 	 * @return will null value
	 */
	public Integer twoDarray(int M,int N)
	{		
		int[][] array = new int[M][N];
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				array[i][j]=scanner.nextInt(); //accept array elements 
											  //from user
			}
		}
		System.out.println("2D array : \n");
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				printwriter.print(array[i][j]+" ");//printing 2D array
			}
			//printwriter.println( );
		}
		
		return null;
	}
	
/**************************Sum of Three Integer******************/
	
	/**In this method we created an array , And in that array
	 * we check any three numbers whose addition is 0
	 * we call those 3 number as triplet 
	 * @param arr where triplet is store
	 * @param number is array range which store total number of 
	 *  elements you entered in array
	 */
	public static void cal(int[] arr,int number) 
    {
		 for(int i=0;i<number-2;i++)
		 {
			 for(int j=i+1;j<number-1;j++) 
			 {
				 for(int k=j+1;k<number;k++)
				 {
					 //addition should be equals to 0
					 if(arr[i]+arr[j]+arr[k]==0) //check addition of 3
						 	     //number in array is 0 
					 {
	    				System.out.println("\nTriplets are : ");
	    				System.out.print(arr[i]); 
	                    System.out.print(" "); 
	                    System.out.print(arr[j]); 
	                    System.out.print(" "); 
	                    System.out.print(arr[k]); 
	                    System.out.print("\n");
	                   
	    			 }
	    		 }
			 }
		 }
		 //If in array there is no any 3 number whose addition
		 //is 0 then it will print that there is no any triplet
    }	
	
/*****************Euclidian Distance************************/	
  
	public void euclidianDistance(int x , int y)
	{
		int distance = (int) Math.sqrt(Math.pow(x, 2)+(Math.pow(y, 2)));
		System.out.println("Eucludian distance : " + distance );
	}
	
	
/***************************Permutation*************************/
	
	/** This method swap the elements in array
	 * @param ch store character array
	 * @param i store index element
	 * @param j this also point to array element
	 */
	public static void swap(char[] ch, int i , int j)
	{
		char temp=ch[i];
		ch[i]=ch[j];
		ch[j]=temp;		
	}
	/**This method find permutation of string using recursion
	 * @param ch store character array of string for permutation
	 * @param currentIndex point to current index in array 
	 */
	public static void permutationRecursion(char ch[] , int currentIndex)
	{
		if(currentIndex==ch.length-1)
			System.out.println(String.valueOf(ch));
		for(int i=currentIndex;i<ch.length;i++)
		{
			swap(ch,currentIndex,i);
			permutationRecursion(ch,currentIndex + 1);
			swap(ch,currentIndex,i);
		}
	}		
	
	/**This method is to find permutation of string using recursion
	 * @param ch is used to store character array of string
	 */
/***************************Stopwatch***********************/	
	/**This method takes current time of system  
	 * @param start_time in this we store current system
	 * time
	 * @return will return start-time
	 */
	public Long StartTime(long start_time)
	{
		//System.out.println("\nPress 1 start time");
		if(start_time==0)
		{
		start_time=System.currentTimeMillis();
		return start_time; 
		}
		else
			System.out.println("\n*********Invalid input*******");
		
		return (long) 0;
	}
	
	/**This mathod takes end time of current working system
	 *  when we stop or when we entered time 
	 * @param end_time
	 * @return
	 */
	public Long EndTime(long end_time) 
	{	
		if(end_time==1)
		{
			end_time=System.currentTimeMillis();
			return end_time;
		}
		else
			System.out.println("\n*********Invalid input********");
		return (long) 0; 
	}
	
	/**This method calculate elapsed time for stopwatch
	 * @param start_time store stopwatch start time
	 * @param end_time store time when we stop stopwatch
	 * @return
	 */
	public Long ElapsedTime(long start_time , long end_time)
	{
		long elapsed_time = end_time - start_time;
		return elapsed_time/1000;
	}	

	/****************************Quadratic*************************/
	
	int root1_x ,root2_x;
	/**This method is used to calculate roots for
	 * quadratic equation
	 * @param a is user input to making quadratic equation
	 * @param b is user input to making quadratic equation
	 * @param c is user input to making quadratic equation
	 */
	public void CalculatingRoots(int a , int b , int c)
	{
		double delta =( b*b) - (4*a*c);
		root1_x=(int) ((-b+Math.sqrt(delta))/(2*a));
		root2_x=(int) ((-b-Math.sqrt(delta))/(2*a));
		System.out.println("X = "+root1_x);
		System.out.println("X = "+root2_x);
	}
/************************Wind chill*******************************/
	
	/**
	 * @param t is temperature which is in  Fahrenheit
	 * @param v is speed  miles per hour
	 * @return effective wind chill temperature
	 */
	public void windChillCalculation(double t , double v)
	{
		if(t>50 || (v<3 || v>120))  //This is recursion..to allow user
		{							// to enter input again and again
			System.out.println("You have entered wrong input:");
			System.out.println("Enter T :=");
			t=scanner.nextInt();
			System.out.println("Enter V :=");
			v=scanner.nextInt();
			windChillCalculation(t, v);
		}
		else if(t <=50 && (v>=3 && v<=120))
		{
			long w = 0;
			double raiseToPower = Math.pow(v,0.16);
			w = (long) ((long)35.74 + 0.6215*t+ (0.4275*t-35.75)*raiseToPower);
			System.out.println("Wind chill is : "+w);
		}		
	}
	
									/************************Algorithm Programs*********************/	
	
/****************************Anagram*****************************/
			
	/**This method check entered two string are anagram or not
	 * @param str1 store first string
	 * @param str2 store second string
	 * Now later it compare both strings are anagram or not 
	 */
	public void checkAnangram(String str3 , String str4 )
	{			
        char array1[] = str3.toCharArray();      //convert string 
        char array2[] = str4.toCharArray(); 	//in character array	        
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        if(Arrays.equals(array1, array2))   //check characters of both 
        {									//array is same or not
        	 
        	 System.out.println("String is anangram");
       	}
       	else 
       		 System.out.println("String is not anangram");
      
     }
/*************************Prime Number of range 0 to 1000***************/

	/**This method print prime number from 0 to till the range
	 * whatever you want  
	 * @param range store number and till that it will print
	 * prime numbers
	 */
	public static int[] printingPrimeNumber(int range) 
	{
		   boolean isPrime = true;
		   int count = 0;
		   int primeno[]=new int[range];		   
		   for (int i = 0; i <= range; i++)         
	       { 		  
	          for(int j=2; j<i ;j++)
	          {
	        	     if(i%j==0)
	             	 {
	             	 	isPrime=false;
	             	 	break;
	             	 }
	             	 else 	
	        	     	isPrime=true;
	          	}
	          	if(isPrime==true)
	        	  primeno[count++]=i;
	       }
		return primeno ;		     
	}
	
	
	/************************PrimeAnangramPalindrome*********************/	
	
	/**This method check prime numbers are palindrome or not
	 * @param primenumber: store prime number which we have to check 
	 * whether it is palindrome or not
	 */
	static int reversenum = 0;
    static int remainder=0;

    public static void checkPalindrome(int[] primenumber) {

        for (int i = 0; i < primenumber.length; i++) {
            reversenum=0;
            if (primenumber[i] > 0) {
                int temp = primenumber[i];
                while (temp > 0) 
                {
                    remainder = temp % 10;
                    temp = temp / 10;
                    reversenum = reversenum * 10 + remainder;
                }
                       temp=primenumber[i];
                if (temp == reversenum) 
                    System.out.print(reversenum + " ");                
            }
        }
    }

	/**This method check that prime number is anagram or not
	 * @param primenumber:is prime numbers which we check that numbers are
	 * anangram or not
	 */
    public static int[] checkAnagram(int[] primenumber)
    {
        System.out.println("\nThe prime number which are Anagram:");
        int anagram = 0;
        int[] anagramArray = new int[primenumber.length]; 
        for (int  i = 0; i < primenumber.length; i++)
        {
            for (int j = i+1; j < primenumber.length-1; j++)
            {
                 if(primenumber[i]>0 && primenumber[j]>0 && primenumber[i]!=primenumber[j])
                 {     
	                 String string1 = Integer.toString(primenumber[i]);
	                 String string2 = Integer.toString(primenumber[j]);
	                 anagram = Utility.checkPrimeAnagram(string1, string2);
	                 if(anagram>0)
	                 {
	                	 anagramArray[i] = anagram;
	                	 //anagramArray[i]
	                 }
                 }
            }
        }
		return anagramArray;				        
    }
    
    private static int checkPrimeAnagram(String string1, String string2)
    {
		int anagram =0 ;
		char[] ch1 = string1.toCharArray();
	    char[] ch2 = string2.toCharArray();
	    boolean result=false;
	    Arrays.sort(ch1);
	    Arrays.sort(ch2);
	    result = Arrays.equals(ch1,ch2);
	    if(result==true)
	    {
	    	anagram = Integer.parseInt(string1);
	    	//System.out.print(anagram+" ");
	    	return anagram;
	    }
		return anagram;		
    }  		
	

							/**************************All sorting algo **************************/


/*************************Binarysearch method for integer******************/


/**this method search a integer in sorted array
 * @param arr store sorted int
 * @param Search_ele  is a integer which is to be search
 * @return searching element
 */
public static int BinarySearchInt(int[] arr,int Search_ele)
{
int low=0;
int high=arr.length-1;
int mid;
	while(low<=high)
	{
		mid=(low+high)/2;
		if(arr[mid]==Search_ele)
		{
			return mid;
		}
		else if(arr[mid]<Search_ele)
		{
			low=mid+1;
		}else 
		{
			high=mid-1;
		}
		
	}return -1;

}
/******************************Binarysearch method for String*********/
/** this method search a string or word in sorted list 
 * @param bubbleStringArray store sorted strings 
	 * @param stringsearch is a string which is to be search
 * @return searching element
 */
public static int binaryString(String[] bubbleStringArray , String stringsearch)
{
	int first = 0;
	int last = bubbleStringArray.length;
	int mid = 0;
	while (first <= last) {
		mid = (first + last) / 2;

		if (bubbleStringArray[mid].compareTo(stringsearch) == 0) 
		{
			return mid;
			
		} 
		else if (bubbleStringArray[mid].compareTo(stringsearch) < 0) 
		{
			first = mid + 1;
		} else 
		{
			last = mid - 1;
		}
	}
	
	return -1;
	}

/*****************insertionsort for Integer************************/

public static void InsertionSortInteger(int[] array)
{
     int n = array.length; 
        for (int j = 1; j < n; j++)
        { 
            int key = array[j]; 
            int i = j-1; 
            /**Move elements of array[0..i-1], that are 
            greater than key, to one position ahead 
            of their current position */
            while ( (i > -1) && ( array [i] > key ) )
            { 
                array [i+1] = array [i]; 
                i--; 
            } 
            array[i+1] = key; 
        }
}
/*****************insertionsort for Integer************************/
/**This method sort string data in ascending order using insertion sort
 * @param nString store total number of string given by user
 * @param stringArray store strings entered by user 
 * @return sorted strings 
 */
public static String[] insertionString(int nString , String[] stringArray)
{
	
	String key;
	int j,i;
    for (j = 1; j < stringArray.length; j++) 
    {
    	key=stringArray[j];      //store original in any temporary variable
    	i=j-1;
    	while(i>=0)
    	{
    		if(stringArray[i].compareTo(key)<0)  //comparing 2 strings
    		{
    			break;
    		}
    		stringArray[i+1]=stringArray[i];    //swapping
    		i--;
    	}
    	stringArray[i+1]=key;         
    }
	return stringArray;         // sorted strings 
}
/*****************BubbleSort for Integer************************/
public static void BubbleSortInteger(int[]array)
{
    int length=array.length;
    int temp;
    for(int i=0;i<length;i++)
    {
        for(int j=1;j<(length-i);j++)
        {
            if(array[j-1]>array[j])
            {
                temp=array[j-1];
                array[j-1]=array[j];
                array[j]=temp;
            }
        }
    }
       
}
/*****************BubbleSort for String************************/
/** This method sort the strings in ascending order
 * @param nString :store total how many strings are their in array 
 * @param stringArray : store number of strings 
 * @return :string array ,where sorted strings are stored
 */
public static String[] bubbleString(int nString,String[] stringArray)
{	
	int i,j;
	String temp;
	for(i=0;i<nString-1;i++)
	{
		for(j=0;j<nString-i-1;j++)
		{
			if((stringArray[j]).compareTo(stringArray[j+1]) > 0)
			{
				//swapping
				temp=stringArray[j];
				stringArray[j]=stringArray[j+1];
				stringArray[j+1]=temp;
			}
		}
	}
	
	return stringArray;		
}	

}

