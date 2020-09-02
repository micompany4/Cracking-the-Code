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
	
	
	public static void decimalToBinary(int num)
	{
		int quotient = num;
		int binary[] = new int[64];
		int count = 0;
		
		
		while(quotient != 0)		//no leading zeroes
		{
			binary[count++] = quotient%2;		//set the bit to 0 or 1 depending on it's remainder 
			quotient /= 2;						
			
		}
		
		System.out.print("Binary number: ");
		for(int j = count-1; j >=0; j--)		//the result is inputed backwards, so print it in reverse order
		{	
			System.out.print(binary[j]);
		}
		
		
	}
	
	public static int binaryToDecimal(int[] bin)
	{
		int decimal = 0;
		double index = 0;
		double power = 0;
		
		// if it wasn't an array, you would have to do some "fancy" stuff like /10 and %10
		for(int i = bin.length-1; i >= 0; i--)
		{
			//the logic for converting binary to decimal i.e. the important part 
			index = Math.pow(2, power++);
			if(bin[i] == 1)
			{
				decimal += index;
			}
			
		}
		
		return decimal;
	}

	public static String sumOfBinary(String num1, String num2)
	{
		//pads the beginning of the shorter binary number with 0's so that they line up properly 
		if(num1.length() > num2.length())
		{
			while(num2.length() < num1.length())
			{
				num2 = "0" + num2;
			}
		}
		if(num2.length() > num1.length())
		{
			while(num1.length() < num2.length())
			{
				num1 = "0" + num1;
			}
		}
		
		//formatting purposes to make it look nice
		System.out.println("  " + num1);
		System.out.println("+ " + num2);
		System.out.println("____________");
		
		String binary = "";
		int remainder = 0;		//flag if there is a remainder to add to the calculation 
		
		for(int i = num1.length()-1; i >= 0; i--)
		{
			int bit1 = Integer.parseInt(num1.substring(i, i+1));
			int bit2 = Integer.parseInt(num2.substring(i, i+1));
			
			int sum = (bit1 + bit2 + remainder) % 2;
			remainder = (bit1 + bit2 + remainder) / 2;
			
			binary = ""+sum + binary;
			
		}
		
		//at the end of the operation, if there is still a remainder, append it in the first index
		if(remainder != 0)
		{
			binary = ""+ remainder + binary;
			return " " + binary;		//formatting purposes
		}
		else
		{
			return "  " + binary;		//formatting purposes
		}
		
		
	}
	
	public static void main(String args[])
	{
		int number = 15;
		int bit = 1;
		int binaryNum[] = { 1, 1, 0, };
		
		String b1 = "101";
		String b2 = "110";
		System.out.println(sumOfBinary(b1, b2));
		
	}
	
}
