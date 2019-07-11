package scratch;

public class Char_Array 
{
	//method that takes an array of characters and replaces spaces with "%20"
	//returns the now modified array
	//works in place, the array given should have enough space to do it properly 
	public static char[] noSpaces(char[] string)
	{
		char[] temp = string.clone();				//a temp array to hold the currently being modified array via cloning
		int c = 0;									// a counter variable to keep track where in the array we are replacing
		
		//loops through the entire character array looking for spaces
		for(int i = 0; i < string.length; i++)
		{
			if(string[i] == ' ')
			{
				//hard set the desired characters in place
				string[i] = '%';
				string[i+1] = '2';
				string[i+2] = '0';
				c = i+1;							//updates the counter to the correct position
				
				//changes the remaining characters in the array to 
				for(int j = i+3; j < string.length; j++)
				{
					string[j] = temp[c++];
				}
				
				
				temp = string.clone();				//update the temp array (look into this if can't understand why)
			}
		}
		
		return string;
	}
	
	public static void main(String args[])
	{
		char line[] = {'M', 'o', 'm', 'o', ' ', 'S', '.' ,' ', 'D', 'e', 'v', 'i', 'l', 'u', 'k', 'e', ' ', ' ', ' ', ' '};
		char line2[] = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' '};
		noSpaces(line);
		
		for(int i = 0; i < line.length; i++)
		{
			System.out.print(line[i]);
		}
	}
}
