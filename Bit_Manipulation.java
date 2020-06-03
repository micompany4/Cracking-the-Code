package scratch;

/*
 * Some bit manipulation methods implemented in Java
 */
public class Bit_Manipulation 
{
	//get the bit in n
	public static int getBit(int n, int bit)
	{
		//get a bit number with all 0's except the bit, bit; ex 0010
		//then AND it with n; it'll be either zero or non-zero
		boolean cond =  ((n & (1 << bit)) != 0);
		if(cond)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	//set that bit in n to 1 and returns the new number
	public static int setBit(int n, int bit)
	{
		 return n|(1<<bit);
	}
	
	//set that bit in n to 0
	public static int clearBit(int n, int bit)
	{
		return n&~(1<<bit);
	}
	
	//check and see if that bit in n is a 1 
	public static boolean isSet(int n, int bit)
	{
		int cond = n&(1<<bit);
		if(cond != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public static void main(String args[])
	{
		int number = 6;
		int bit = 1;
		System.out.println(getBit(number, bit));
	}
	
}
