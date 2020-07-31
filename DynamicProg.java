package scratch;

public class DynamicProg {

	/*
	 Write a recursive function to multiply two positive integers without using the
	 "*" operator (multiplication).You can use addition, subtraction, and bit shifting, but you should minimize the number
	 of those operations.
	 @param n the first number in the multiplication problem
	 @param c the second number, used to count down  
	 */
	public static int recursiveMult(int n, int c)
	{
		//base case when the counter equals zero
		if(c == 0)
		{
			return 0;
		}

		return n + recursiveMult(n, c-1);
	}


	public static void main(String[] args)
	{
		int a = 6; 
		int b = 11;

		System.out.println(recursiveMult(a, b));
	}

}
